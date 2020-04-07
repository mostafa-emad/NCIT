package ncit.test.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import ncit.test.R;
import ncit.test.data.ws.model.response.UserResponse;
import ncit.test.databinding.ActivitySignInBinding;

public class SignInActivity extends BaseAuthActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.usernameTxt.getText().toString();
                if(username.isEmpty()){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.username_empty_msg),Toast.LENGTH_LONG).show();
                    return;
                }
                String password = binding.passwordTxt.getText().toString();
                if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.password_empty_msg),Toast.LENGTH_LONG).show();
                    return;
                }

                userViewModel.login(username,password).observe(SignInActivity.this, new Observer<UserResponse>() {
                    @Override
                    public void onChanged(UserResponse baseResponse) {
                        if(baseResponse.getError_id()!= -1){
                            userViewModel.setLoginEnabled(true);
                            openMainScreen();
                        }else{
                            Toast.makeText(getApplicationContext(),baseResponse.getError_name(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        binding.forgetPasswordTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

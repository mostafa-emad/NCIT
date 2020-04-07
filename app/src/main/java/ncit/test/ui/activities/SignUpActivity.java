package ncit.test.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import ncit.test.R;
import ncit.test.data.ws.model.response.UserResponse;
import ncit.test.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseAuthActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
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
                String confirmPassword = binding.confirmPasswordTxt.getText().toString();
                if(confirmPassword.isEmpty()){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.confirmed_empty_msg),Toast.LENGTH_LONG).show();
                    return;
                }
                if(!password.equals(confirmPassword)){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.password_not_matched_msg),Toast.LENGTH_LONG).show();
                    return;
                }
                userViewModel.signUp(username,password).observe(SignUpActivity.this, new Observer<UserResponse>() {
                    @Override
                    public void onChanged(UserResponse baseResponse) {
                        if(baseResponse.getError_id() != -1){
                            Toast.makeText(getApplicationContext(),baseResponse.getResponse_name(),Toast.LENGTH_LONG).show();
                            openSignIn();
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(),baseResponse.getError_name(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}

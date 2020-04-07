package ncit.test.ui.activities;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import ncit.test.R;
import ncit.test.databinding.ActivityStartUpBinding;

public class StartupActivity extends BaseActivity {
    private ActivityStartUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_start_up);

        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignIn();
            }
        });

        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });
    }
}

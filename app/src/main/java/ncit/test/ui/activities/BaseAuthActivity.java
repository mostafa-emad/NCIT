package ncit.test.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import ncit.test.ui.vm.UserViewModel;

@SuppressLint("Registered")
public class BaseAuthActivity extends BaseActivity {
    protected UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init(this);
    }
}

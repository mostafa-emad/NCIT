package ncit.test.ui.activities;

import android.os.Bundle;
import android.os.Handler;

import androidx.lifecycle.ViewModelProviders;

import ncit.test.R;
import ncit.test.ui.vm.BaseViewModel;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final BaseViewModel baseViewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
        baseViewModel.init(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(baseViewModel.isUserLoggedIn()){
                    openMainScreen();
                }else{
                    openStartUp();
                }
            }
        },2000);
    }
}

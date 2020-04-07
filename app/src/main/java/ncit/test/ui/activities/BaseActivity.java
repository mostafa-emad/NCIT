package ncit.test.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateResources("ar");
    }

    protected void openStartUp(){
        Intent intent = new Intent(this,StartupActivity.class);
        startActivity(intent);
        finish();
    }

    protected void openSignUp(){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }

    protected void openSignIn(){
        Intent intent = new Intent(this,SignInActivity.class);
        startActivity(intent);
    }

    protected void openMainScreen(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void updateResources(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            getViewModelStore().clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

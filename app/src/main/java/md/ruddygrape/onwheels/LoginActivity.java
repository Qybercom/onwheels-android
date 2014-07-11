package md.ruddygrape.onwheels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.widget.LoginButton;

import java.util.Arrays;

public class LoginActivity extends Activity {
    private FacebookHelper fHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fHelper = new FacebookHelper();
        fHelper.createHelper(this, savedInstanceState);

        LoginButton authButton = (LoginButton) findViewById(R.id.al_authButton);
        authButton.setReadPermissions(Arrays.asList("user_likes", "user_status"));
    }

    @Override
    public void onResume() {
        super.onResume();
        fHelper.resumeHelper();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fHelper.resultHelper(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        super.onPause();
        fHelper.pauseHelper();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fHelper.destroyHelper();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        fHelper.saveHelper(outState);
    }
}

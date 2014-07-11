package md.ruddygrape.onwheels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

public class FacebookHelper {
    UiLifecycleHelper uiHelper;

    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };

    public void createHelper(Activity context, Bundle savedInstanceState) {
        uiHelper = new UiLifecycleHelper(context, callback);
        uiHelper.onCreate(savedInstanceState);
    }

    public void resumeHelper() {
        uiHelper.onResume();
    }

    public void resultHelper(int requestCode, int resultCode, Intent data) {
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    public void pauseHelper() {
        uiHelper.onPause();
    }

    public void destroyHelper() {
        uiHelper.onDestroy();
    }

    public void saveHelper(Bundle outState) {
        uiHelper.onSaveInstanceState(outState);
    }

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            Log.e("Facebook", "logged in");
        } else {
            Log.e("Facebook", "logged out");
        }
    }
}

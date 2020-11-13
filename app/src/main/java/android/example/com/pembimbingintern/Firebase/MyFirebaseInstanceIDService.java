package android.example.com.pembimbingintern.Firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG="MyFirebaseIIDService";

    public void onTokenRefresh(){
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG,"Refresh Token: " + refreshedToken);

        storeToken(refreshedToken);
    }

    private void storeToken(String token) {
        SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);
    }
}

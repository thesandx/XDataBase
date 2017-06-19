package com.example.manojkumarjha.xdatabase;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by MANOJ KUMAR JHA on 19-Jun-17.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{
    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public  void onTokenRefresh(){
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG,"Refreshed Token: "+refreshedToken);
    }

    private void sendRegistrationToServer(String token){

    }
}

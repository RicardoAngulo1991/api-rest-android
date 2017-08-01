package com.example.ricardoangulo.api_rest_android;

import android.app.Application;
import android.widget.Toast;
import com.androidnetworking.AndroidNetworking;

/**
 * Created by RicardoAngulo on 01/08/2017.
 */

public class ApiRestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        Toast.makeText(ApiRestApplication.this, "Todo bien ", Toast.LENGTH_SHORT);
    }
}

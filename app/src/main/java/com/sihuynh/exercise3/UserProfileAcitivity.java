package com.sihuynh.exercise3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 15/10/2017.
 */

public class UserProfileAcitivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Intent i= getIntent();
        if (i!=null){
            if (i.hasExtra(Intent.EXTRA_TEXT)){
                // TODO set value from extra to textview
                String userName = i.getExtras().getString(Intent.EXTRA_TEXT);//2 dòng nhu nhau

               // userName=i.getStringExtra(Intent.EXTRA_TEXT);
                TextView tvUserName=(TextView) findViewById(R.id.setName);
                tvUserName.setText(userName);
            }
        }
        NetworkChangeReceiver receiver =new NetworkChangeReceiver();
        registerReceiver(receiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }
    private class NetworkChangeReceiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {


            ConnectivityManager cm =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo =cm.getActiveNetworkInfo();
            boolean isConneted = networkInfo !=null && networkInfo.isConnectedOrConnecting();
            //TODO start service when online
            Toast.makeText(context,"onReceiver network change"+isConneted,Toast.LENGTH_LONG).show();
            Intent intentService = new Intent(context,NetworkService.class);
            if (isConneted){
                //TODO start service when online
                startService(intentService);
            }else {
                //TODO sstop server when ofilne
                stopService(intentService);
            }
        }
    }
}

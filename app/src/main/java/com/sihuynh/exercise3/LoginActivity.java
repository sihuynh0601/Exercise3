package com.sihuynh.exercise3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editTextName=(EditText) findViewById(R.id.edtName);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO :VALIADATE INPUT FROM USER

                //START USER PROFILE and push data to user and finish
                Intent intent = new Intent(LoginActivity.this,UserProfileAcitivity.class);
                intent.putExtra(Intent.EXTRA_TEXT,editTextName.getText().toString());
                startActivity(intent);
                finish();

            }
        });

    }

}

package com.example.carnetdigital.Vista;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;


import com.example.carnetdigital.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }

        firebaseAuth = FirebaseAuth.getInstance();
        int tiempo = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*startActivity(new Intent(PantallaDeCarga.this,MainActivity.class));
                finish();*/
                VerificacionUsuario();
            }
        }, tiempo);


    } private void VerificacionUsuario(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        startActivity(new Intent(MainActivity.this, menu_principal.class));
        finish();

    }

}

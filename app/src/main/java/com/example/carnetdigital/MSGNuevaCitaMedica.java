package com.example.carnetdigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carnetdigital.Vista.GUI_AdultoMayor;
import com.example.carnetdigital.Vista.MainActivity;

public class MSGNuevaCitaMedica extends AppCompatActivity {

    Button BbtnVolverS, BbtnCrearC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msgnueva_cita_medica);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        BbtnVolverS = (Button) findViewById(R.id.BbtnVolverS);

        BbtnCrearC = (Button) findViewById(R.id.BbtnCrearC);

        BbtnVolverS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MSGNuevaCitaMedica.this, GUI_AdultoMayor.class);
                startActivity(intent);
            }
        });

        BbtnCrearC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MSGNuevaCitaMedica.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
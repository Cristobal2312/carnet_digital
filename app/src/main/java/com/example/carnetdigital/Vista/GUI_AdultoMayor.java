package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carnetdigital.R;

public class GUI_AdultoMayor extends AppCompatActivity {

    Button bntMas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_adulto_mayor);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        bntMas = (Button) findViewById(R.id.CbtnMas);




        bntMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GUI_AdultoMayor.this, GUI_AdultoMayorPAG_2.class);
                startActivity(intent);
            }
        });




    }
}
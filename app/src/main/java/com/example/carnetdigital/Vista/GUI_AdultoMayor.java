package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
package com.example.carnetdigital.Vista;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.carnetdigital.Controlador.NuevaClaseDBHelper;
import com.example.carnetdigital.MSGNuevaCitaMedica;
import com.example.carnetdigital.Modelo.Cita;
import com.example.carnetdigital.Modelo.CitaAdapter;
import com.example.carnetdigital.R;
import java.util.List;

public class carnetMedico extends AppCompatActivity {

    private NuevaClaseDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_medico);

        dbHelper = new NuevaClaseDBHelper(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        // Asigna clic listeners a los botones
        Button btnNuevaCita = findViewById(R.id.BbtnNuevaCita);
        Button btnVolver = findViewById(R.id.BbbtnVolver);

        btnNuevaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(carnetMedico.this, MSGNuevaCitaMedica.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Llamada al método para mostrar la lista de citas
        mostrarListaDeCitas();
    }

    // Método para mostrar la lista de citas
    private void mostrarListaDeCitas() {
        // Obtén la lista de citas de la base de datos
        List<Cita> listaDeCitas = obtenerListaDeCitasDesdeDB();

        // Asigna la lista de citas a tu adaptador y actualiza la interfaz
        CitaAdapter adaptador = new CitaAdapter(this, listaDeCitas);
        ListView listView = findViewById(R.id.listViewTerapeutas);
        listView.setAdapter(adaptador);
    }

    private List<Cita> obtenerListaDeCitasDesdeDB() {
        // Aquí deberías llamar al método en NuevaClaseDBHelper para obtener la lista de citas
        return dbHelper.obtenerListaDeCitas();
    }
}

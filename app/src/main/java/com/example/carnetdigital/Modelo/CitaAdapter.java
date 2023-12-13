package com.example.carnetdigital.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.carnetdigital.R;

import java.util.List;

public class CitaAdapter extends ArrayAdapter<Cita> {

    public CitaAdapter(Context context, List<Cita> citas) {
        super(context, 0, citas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener el objeto Cita para esta posición
        Cita cita = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_cita, parent, false);
        }

        // Buscar las vistas en el layout del item_cita
        TextView terapeutaTextView = convertView.findViewById(R.id.textViewTerapeuta);
        TextView fechaTextView = convertView.findViewById(R.id.textViewFecha);
        TextView horaTextView = convertView.findViewById(R.id.textViewHora);

        // Mostrar los datos en las vistas
        terapeutaTextView.setText(cita.getTerapeuta());
        fechaTextView.setText(cita.getFecha());
        horaTextView.setText(cita.getHora());

        return convertView;
    }
}

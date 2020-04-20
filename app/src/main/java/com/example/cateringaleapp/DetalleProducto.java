package com.example.cateringaleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleProducto extends AppCompatActivity {

    private TextView nomProd, descProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        nomProd = (TextView) findViewById(R.id.lblDPTitulo);
        descProd = (TextView) findViewById(R.id.lblDPDescripcion);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String descripcion = bundle.getString("descripcion");

        nomProd.setText(nombre);
        descProd.setText(descripcion);

    }
}

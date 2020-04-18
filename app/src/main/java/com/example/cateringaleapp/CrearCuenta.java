package com.example.cateringaleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearCuenta extends AppCompatActivity {

    Button btnCrearCuenta;
    EditText txtNombre, txtCorreo,txtContraseña;//txtTelefono,txtDireccion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);


        btnCrearCuenta = (Button) findViewById(R.id.btnRegistrar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
        /*txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);*/


    }


    public void RegistrarCuenta(View view){


        boolean faltanDatos = false;

        String Nombre = txtNombre.getText().toString();
        String Correo = txtCorreo.getText().toString();
        String Contraseña = txtContraseña.getText().toString();
        /*String Telefono = txtTelefono.getText().toString();
        String Direccion = txtDireccion.getText().toString();*/

        if(Nombre.isEmpty()){
            faltanDatos = true;
            txtNombre.setError("Dato requerido.");
        }
        else{
            txtNombre.setError(null);
        }

        if(Correo.isEmpty()){
            faltanDatos = true;
            txtCorreo.setError("Dato requerido.");
        }else{
            txtCorreo.setError(null);
        }

        if(Contraseña.isEmpty()){
            faltanDatos = true;
            txtContraseña.setError("Dato requerido.");
        }else{
            txtContraseña.setError(null);
        }
/*
        if(Telefono.isEmpty()){
            faltanDatos = true;
            txtTelefono.setError("Dato requerido.");
        }else{
            txtTelefono.setError(null);
        }

        if(Direccion.isEmpty()){
            faltanDatos = true;
            txtDireccion.setError("Dato requerido.");
        }else{
            txtDireccion.setError(null);
        }
*/


        if(faltanDatos){

            Toast.makeText(this,"Favor de completar los datos requeridos.",Toast.LENGTH_LONG).show();
        }else
        {
            Intent anterior = new Intent(this,IniciarSesion.class);
            startActivity(anterior);
        }



    }
}

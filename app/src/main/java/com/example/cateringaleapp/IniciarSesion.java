package com.example.cateringaleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IniciarSesion extends AppCompatActivity {

    private Button btnIngresar;
    private EditText txtUsuario, txtContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);


        btnIngresar =  (Button) findViewById(R.id.btnISIngresar);
        txtUsuario = (EditText) findViewById(R.id.txtISUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtISContraseña);


    }


    public void ValidarCredenciales(View view){

        boolean faltanDatos = false;
        String usuario = txtUsuario.getText().toString();
        String contraseña = txtContraseña.getText().toString();


        if(usuario.isEmpty()){
            faltanDatos = true;
            txtUsuario.setError("Dato requerido.");
        }
        else{
            txtUsuario.setError(null);
        }

        if(contraseña.isEmpty()){
            faltanDatos = true;
            txtContraseña.setError("Dato requerido.");
        }else{
            txtContraseña.setError(null);
        }


        if(faltanDatos){

            Toast.makeText(this,"Favor de completar los datos requeridos.",Toast.LENGTH_LONG).show();

        }else{

            Intent anterior = new Intent(this,MainActivity.class);
            startActivity(anterior);

        }


    }

    public void CrearCuenta(View view){

        Intent anterior = new Intent(this,CrearCuenta.class);
        startActivity(anterior);

    }



}

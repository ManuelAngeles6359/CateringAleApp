package com.example.cateringaleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CrearCuenta extends AppCompatActivity {

    Button btnCrearCuenta;
    EditText txtNombre, txtCorreo, txtContraseña, txtApPat, txtApMat;//txtTelefono,txtDireccion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);


        btnCrearCuenta = (Button) findViewById(R.id.btnRegistrar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
        txtApMat = (EditText) findViewById(R.id.txtApMat);
        txtApPat = (EditText) findViewById(R.id.txtApPat);
    }


    public void RegistrarCuenta(View view) {


        boolean faltanDatos = false;

        String Nombre = txtNombre.getText().toString();
        String Correo = txtCorreo.getText().toString();
        String Contraseña = txtContraseña.getText().toString();
        /*String Telefono = txtTelefono.getText().toString();
        String Direccion = txtDireccion.getText().toString();*/

        if (Nombre.isEmpty()) {
            faltanDatos = true;
            txtNombre.setError("Dato requerido.");
        } else {
            txtNombre.setError(null);
        }

        if (Correo.isEmpty()) {
            faltanDatos = true;
            txtCorreo.setError("Dato requerido.");
        } else {
            txtCorreo.setError(null);
        }

        if (Contraseña.isEmpty()) {
            faltanDatos = true;
            txtContraseña.setError("Dato requerido.");
        } else {
            txtContraseña.setError(null);
        }

        if(faltanDatos){

            Toast.makeText(this,"Favor de completar los datos requeridos.",Toast.LENGTH_LONG).show();
        }else
        {
            String url = "http://catteringale.onlinewebshop.net/index.php/usuario";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast toast = Toast.makeText(CrearCuenta.this, "Se insertó correctamente al usuario", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("======>", error.toString());
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap();
                    params.put("nombre", txtNombre.getText().toString());
                    params.put("paterno", txtApPat.getText().toString());
                    params.put("materno", txtApMat.getText().toString());
                    params.put("correo", txtCorreo.getText().toString());
                    params.put("clave", txtContraseña.getText().toString());
                    params.put("telefono", "");
                    params.put("direccion", "");
                    params.put("estado", "1");
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);


            Intent anterior = new Intent(this,IniciarSesion.class);
            startActivity(anterior);
        }
    }
}
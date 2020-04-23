package com.example.cateringaleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DetalleProducto extends AppCompatActivity {

    private TextView nomProd, descProd;
    private ImageView imgProd;
    RequestQueue request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        nomProd = (TextView) findViewById(R.id.lblDPTitulo);
        descProd = (TextView) findViewById(R.id.lblDPDescripcion);
        imgProd = (ImageView) findViewById(R.id.imgDPImagen);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String descripcion = bundle.getString("descripcion");
        String rutaImagen = bundle.getString("rutaImagen");
        Log.i("======>", rutaImagen);

        nomProd.setText(nombre);
        descProd.setText(descripcion);

        ImageRequest imgRequest = new ImageRequest(rutaImagen, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imgProd.setImageBitmap(response);

            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("======>", "Error cargar imagen");

            }
        });
        request.add(imgRequest);

    }
}

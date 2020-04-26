package com.example.cateringaleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.cateringaleapp.ui.Entidades.DetallePedido;
import com.example.cateringaleapp.ui.Entidades.Global;
import com.example.cateringaleapp.ui.Entidades.Pedido;
import com.example.cateringaleapp.ui.nuevoPedido.NuevoPedido;

public class DetalleProducto extends AppCompatActivity {

    private TextView nomProd, descProd;
    private ImageView imgProd;
    private EditText txtDPCantidad;
    RequestQueue request;

    private Integer codigoProducto;
    private String nombreProducto;
    private float precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        nomProd = (TextView) findViewById(R.id.lblDPTitulo);
        descProd = (TextView) findViewById(R.id.lblDPDescripcion);
        imgProd = (ImageView) findViewById(R.id.imgDPImagen);
        txtDPCantidad = (EditText) findViewById(R.id.txtDPCantidad);

        Bundle bundle = getIntent().getExtras();
        codigoProducto = bundle.getInt("codigoProducto");
        nombreProducto = bundle.getString("nombre");
        String descripcion = bundle.getString("descripcion");
        String rutaImagen = bundle.getString("rutaImagen");
        precio= bundle.getFloat("precio");
        Log.i("======>", rutaImagen);


        nomProd.setText(nombreProducto);
        descProd.setText(descripcion);


        boolean productoEnLista = false;
        Integer posicionDeProductoEnLista =0;
        for (int i=0; i<Pedido.getListaDeProductos().size(); i++) {
            if(Pedido.getListaDeProductos().get(i).getIdProducto()==codigoProducto){
                posicionDeProductoEnLista = i;
                productoEnLista = true;
            }
        }
        if(productoEnLista){
            txtDPCantidad.setText(Pedido.getListaDeProductos().get(posicionDeProductoEnLista).getCantidad().toString());
        }
        else
        {
            txtDPCantidad.setText("0");
        }



/*
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
*/
    }


    public void AñadirProductoAlPedido(View view){

        if(Integer.parseInt(txtDPCantidad.getText().toString())<=0){
            txtDPCantidad.setError("Ingrese una cantidad mayor a cero.");
            return;
        }else{
            txtDPCantidad.setError(null);
        }



        Pedido.setIdZonaAtencion(5);
        Pedido.setIdPedido(50);
        Pedido.setIGV((float) 50d);
        Pedido.setSubtotal((float) 80d);
        Pedido.setTotal((float) 150d);


        DetallePedido detallePedido = new DetallePedido();

        detallePedido.setIdProducto(codigoProducto);
        detallePedido.setNombre(nombreProducto);
        detallePedido.setPrecio(precio);
        detallePedido.setCantidad(Integer.parseInt(txtDPCantidad.getText().toString()));
        detallePedido.setSubtotal(Integer.parseInt(txtDPCantidad.getText().toString())*precio);

        boolean productoEnLista = false;
        Integer posicionDeProductoEnLista =0;
        for (int i=0; i<Pedido.getListaDeProductos().size(); i++) {
            if(Pedido.getListaDeProductos().get(i).getIdProducto()==codigoProducto){
                posicionDeProductoEnLista = i;
                productoEnLista = true;
            }
        }

        if(productoEnLista){
            Pedido.getListaDeProductos().set(posicionDeProductoEnLista,detallePedido);
        }else{
            Pedido.AñadirProductoAlPedido(detallePedido);
        }


        Toast.makeText(this,"Producto añadido correctamente.",Toast.LENGTH_SHORT).show();

        //Log.i("======>", (String.valueOf(Pedido.TotalProductosEnPedido())));
/*
        for (int i=0; i<Pedido.TotalProductosEnPedido(); i++) {
            Log.i("======>", (String.valueOf(i).toString()));
            Log.i("======>", Pedido.getListaDeProductos().get(i).getNombre());
        }
*/

    }


    public void ListarProductos(View view){
/*

*/
        if(Pedido.getListaDeProductos().size()>0){
            Intent Pedido = new Intent(view.getContext(), NuevoPedido.class);
            startActivity(Pedido);
        }else
        {
            Toast.makeText(this,"Pedido sin productos.",Toast.LENGTH_LONG).show();
        }



    }


}

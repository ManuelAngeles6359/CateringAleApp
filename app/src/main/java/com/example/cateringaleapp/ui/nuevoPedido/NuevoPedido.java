package com.example.cateringaleapp.ui.nuevoPedido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cateringaleapp.DetalleProducto;
import com.example.cateringaleapp.IniciarSesion;
import com.example.cateringaleapp.MainActivity;
import com.example.cateringaleapp.R;
import com.example.cateringaleapp.ui.Adaptadores.DetallePedidoNuevoAdapter;
import com.example.cateringaleapp.ui.Entidades.DetallePedido;
import com.example.cateringaleapp.ui.Entidades.Global;
import com.example.cateringaleapp.ui.Entidades.Pedido;
import com.example.cateringaleapp.ui.productos.ProductoFragment;
import com.example.cateringaleapp.ui.registrarpedido.RegistrarPedidoFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NuevoPedido extends AppCompatActivity {

    private List<DetallePedido> detallePedidoList = new ArrayList<>();
    private RecyclerView rvDetallePedido;
    private DetallePedidoNuevoAdapter detallePedidoNuevoAdapter;
    private TextView txtNPSubTotal, txtNPIGV, txtNPTotal, txtNPFechaEntrega, txtNPLugarEntrega, txtNPNumeroPedido;

    private Button btnNPRegistrar, btnNPCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_pedido);

        txtNPSubTotal = (TextView) findViewById(R.id.txtNPSubTotal);
        txtNPIGV = (TextView) findViewById(R.id.txtNPIGV);
        txtNPTotal = (TextView) findViewById(R.id.txtNPTotal);
        txtNPFechaEntrega = (TextView) findViewById(R.id.txtNPFechaEntrega);
        txtNPLugarEntrega = (TextView) findViewById(R.id.txtNPLugarEntrega);
        btnNPRegistrar = (Button) findViewById(R.id.btnNPRegistrar);
        btnNPCancelar = (Button) findViewById(R.id.btnNPCancelar);
        txtNPNumeroPedido = (TextView) findViewById(R.id.txtNPNumeroPedido);
        rvDetallePedido = (RecyclerView) findViewById(R.id.rvDetallePedido);

        detallePedidoNuevoAdapter = new DetallePedidoNuevoAdapter(Pedido.getListaDeProductos());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvDetallePedido.setLayoutManager(mLayoutManager);
        rvDetallePedido.setItemAnimator(new DefaultItemAnimator());
        rvDetallePedido.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        rvDetallePedido.setAdapter(detallePedidoNuevoAdapter);

        //preparePeliculaData();
        //mAdapter.notifyDataSetChanged();

        float subTotal = 0, IGV =0, total =0;
        for (int i=0; i<Pedido.getListaDeProductos().size(); i++) {
            subTotal = subTotal + Pedido.getListaDeProductos().get(i).getSubtotal();
        }
        IGV = subTotal * (float)0.18;
        total = subTotal + IGV;


        txtNPSubTotal.setText(String.format("%.2f",subTotal));
        txtNPIGV.setText(String.format("%.2f",IGV));
        txtNPTotal.setText(String.format("%.2f",total));




    }

    public boolean CamposObligatoriosComepletos(){
        boolean estado = true;

        if(txtNPFechaEntrega.getText().toString().length()==0){
            txtNPFechaEntrega.setError("Ingrese la fecha de entrega.");
            estado = false;
        }else{
            txtNPFechaEntrega.setError(null);
        }

        if(txtNPLugarEntrega.getText().toString().length()==0){
            txtNPLugarEntrega.setError("Ingrese el lugar de entrega.");
            estado = false;
        }else{
            txtNPLugarEntrega.setError(null);
        }


        return estado;
    }




    public void RegistrarPedido(View view){


        if(!CamposObligatoriosComepletos()){
            return;
        }

        for (int i=0; i<Pedido.getListaDeProductos().size(); i++) {
            Log.i("======>", (String.valueOf(i).toString()));
            Log.i("======>", Pedido.getListaDeProductos().get(i).getNombre());
        }

        String url = "http://catteringale.onlinewebshop.net/index.php/insertarPedido";

        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            //Log.i("======>", jsonArray.getJSONObject(0).getString("CodigoPedido"));
                            Integer CodigoPedido = Integer.valueOf (jsonArray.getJSONObject(0).getString("CodigoPedido"));
                            Pedido.setIdPedido(CodigoPedido);
                            RegistrarDetalleDePedido();
                            txtNPNumeroPedido.setText(Pedido.getIdPedido().toString());
                            Toast.makeText(NuevoPedido.this,"Pedido registrado correctamente.",Toast.LENGTH_LONG).show();
                            IniciarNuevoPedido();
                        } catch (Exception e) {
                            Log.i("======>", e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() {
                //$fechaPedido, $fechaEntrega, $estado, $subtotal, $igv, $total, $idUsuario, $idZonaatencion, $direccionentrega
                Map<String, String> params = new HashMap();
                params.put("fechaPedido", "27/04/2020");
                params.put("fechaEntrega", txtNPFechaEntrega.getText().toString());
                params.put("estado", "R");
                params.put("subtotal", txtNPSubTotal.getText().toString());//
                params.put("igv", txtNPIGV.getText().toString());//
                params.put("total", txtNPTotal.getText().toString());
                params.put("idUsuario", Pedido.getIdUsuario().toString());
                params.put("idZonaatencion", "1");
                params.put("direccionentrega", txtNPLugarEntrega.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


    public void RegistrarDetalleDePedido(){

        String url = "http://catteringale.onlinewebshop.net/index.php/insertarDetallePedido";

        for (int i = 0; i<Pedido.getListaDeProductos().size(); i++) {

            final int posicion = i;
            final StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {

                                Log.i("======>", "Detalle registrado correctamente." + String.valueOf(posicion));


                            } catch (Exception e) {
                                Log.i("======>", e.getMessage());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("======>", error.toString());
                        }
                    }
            ){
                @Override
                protected Map<String, String> getParams() {
                    //$id_pedido, $id_producto, $precio, $cantidad
                    Map<String, String> params = new HashMap();
                    params.put("id_pedido", Pedido.getIdPedido().toString());
                    params.put("id_producto", Pedido.getListaDeProductos().get(posicion).getIdProducto().toString());
                    params.put("precio", Pedido.getListaDeProductos().get(posicion).getPrecio().toString());
                    params.put("cantidad", Pedido.getListaDeProductos().get(posicion).getCantidad().toString());
                    return params;
                }
            };

            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);


        }


    }


    public void IniciarNuevoPedido(){
        Pedido.setIdPedido(0);
        Pedido.IniciarDetallePedido();

    }

    public void CancelarPedido(View view){
        IniciarNuevoPedido();
        Toast.makeText(this,"Pedido cancelado.",Toast.LENGTH_LONG).show();
        Intent MenuPrincipal = new Intent(view.getContext(), MainActivity.class);
        startActivity(MenuPrincipal);

    }

}

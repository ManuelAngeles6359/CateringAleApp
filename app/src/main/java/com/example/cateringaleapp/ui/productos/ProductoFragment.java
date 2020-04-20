package com.example.cateringaleapp.ui.productos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cateringaleapp.DetalleProducto;
import com.example.cateringaleapp.R;
import com.example.cateringaleapp.ui.Adaptadores.ProductoAdapter;
import com.example.cateringaleapp.ui.Entidades.Producto;
import com.example.cateringaleapp.ui.miperfil.MiPerfilFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductoFragment extends Fragment {

    ProductoAdapter productoAdapter;
    ListView lvProducto;
    private static Context ctx;

    public ProductoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ctx = getContext();
        View root = inflater.inflate(R.layout.fragment_producto, container, false);
        String url = "http://catteringale.onlinewebshop.net/index.php/productos";
        lvProducto = (ListView) root.findViewById(R.id.lvProducto);
        final List<Producto> ListaProducto = new ArrayList<>();

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.i("======>", jsonArray.toString());

                    Producto producto = new Producto();

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        producto.setNombre(object.getString("nombre"));
                        producto.setPrecio(Float.parseFloat(object.getString("precio")));
                        producto.setDescripcion(object.getString("descripcion"));

                        if (object.getString("enpromocion").equals("S")) {
                            producto.setEnPromocion("Sí");
                        } else {
                            producto.setEnPromocion("No");
                        }

                        ListaProducto.add(producto);
                        producto = new Producto();
                    }

                    productoAdapter = new ProductoAdapter(getActivity(),ListaProducto);
                    lvProducto.setAdapter(productoAdapter);

                } catch (JSONException e) {
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
        );
        RequestQueue requestQueue= Volley.newRequestQueue(ctx);
        requestQueue.add(stringRequest);/*

        //productoAdapter = new ProductoAdapter(getActivity(),ListaProducto);
        //lvProducto.setAdapter(productoAdapter);*/

        /*Producto pro0 = new Producto();
        Producto pro1 = new Producto();
        Producto pro2 = new Producto();
        Producto pro3 = new Producto();
        Producto pro4 = new Producto();

        pro0.setNombre("Torta de chocolate");
        pro0.setPrecio((float) 90);
        pro0.setEnPromocion ("No");

        pro1.setNombre("Tiramisú");
        pro1.setPrecio((float) 45);
        pro1.setEnPromocion ("Si");

        pro2.setNombre("Milhojas");
        pro2.setPrecio((float) 75);
        pro2.setEnPromocion ("Si");

        pro3.setNombre("Alfajores");
        pro3.setPrecio((float) 60);
        pro3.setEnPromocion ("No");

        pro4.setNombre("Crepe");
        pro4.setPrecio((float) 35);
        pro4.setEnPromocion ("Si");

        final List<Producto> ListaProducto = new ArrayList<>();
        ListaProducto.add(pro0);
        ListaProducto.add(pro1);
        ListaProducto.add(pro2);
        ListaProducto.add(pro3);
        ListaProducto.add(pro4);

        productoAdapter = new ProductoAdapter(getActivity(),ListaProducto);
        lvProducto.setAdapter(productoAdapter);*/

        lvProducto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detalle = new Intent(view.getContext(), DetalleProducto.class);
                //String desc = parent.getSelectedItem().toString();
                Producto prod = ListaProducto.get(position);
                String nombre = prod.getNombre();
                String descripcion = prod.getDescripcion();
                Float precio = prod.getPrecio();
                detalle.putExtra("descripcion", descripcion);
                detalle.putExtra("nombre", nombre);
                detalle.putExtra("precio", precio);
                startActivity(detalle);
                //Toast.makeText(getActivity(),"Clic en producto",Toast.LENGTH_SHORT).show();
            }
        });

        return root;

    }
}

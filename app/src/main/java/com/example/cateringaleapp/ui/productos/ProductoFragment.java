package com.example.cateringaleapp.ui.productos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cateringaleapp.DetalleProducto;
import com.example.cateringaleapp.R;
import com.example.cateringaleapp.ui.Adaptadores.ProductoAdapter;
import com.example.cateringaleapp.ui.Entidades.Producto;
import com.example.cateringaleapp.ui.miperfil.MiPerfilFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductoFragment extends Fragment {

    ProductoAdapter productoAdapter;
    ListView lvProducto;

    public ProductoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_producto, container, false);

        lvProducto = (ListView) root.findViewById(R.id.lvProducto);

        Producto pro0 = new Producto();
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
        lvProducto.setAdapter(productoAdapter);


        lvProducto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent anterior = new Intent(getActivity(), DetalleProducto.class);
                startActivity(anterior);
                //Toast.makeText(getActivity(),"Clic en producto",Toast.LENGTH_SHORT).show();




            }
        });


        return root;

    }
}

package com.example.cateringaleapp.ui.cerrarsesion;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringaleapp.IniciarSesion;
import com.example.cateringaleapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CerrarSesionFragment extends Fragment {

    public CerrarSesionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.cerrar_sesion_fragment, container, false);


        Intent intent = new Intent(getContext(), IniciarSesion.class);
        startActivity(intent);

        return root;
    }
}

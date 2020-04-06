package com.example.cateringaleapp.ui.iniciarsesion;

import androidx.lifecycle.ViewModelProviders;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringaleapp.R;

public class IniciarSesion extends Fragment {

    private IniciarSesionViewModel mViewModel;
    private Button btnIngresar;
    private EditText txtUsuario, txtContraseña;

    public static IniciarSesion newInstance() {
        return new IniciarSesion();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.iniciar_sesion_fragment, container, false);
        View view = inflater.inflate(R.layout.iniciar_sesion_fragment, container, false);

        btnIngresar =  (Button) view.findViewById(R.id.btnISIngresar);
        txtUsuario = (EditText) view.findViewById(R.id.txtISUsuario);
        txtContraseña = (EditText) view.findViewById(R.id.txtISContraseña);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                    Toast.makeText(getContext(),"Favor de completar los datos requeridos.",Toast.LENGTH_LONG).show();
                }

            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IniciarSesionViewModel.class);
        // TODO: Use the ViewModel
    }

}

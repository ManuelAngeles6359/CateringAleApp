package com.example.cateringaleapp.ui.miperfil;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cateringaleapp.R;

public class MiPerfilFragment extends Fragment {

    private MiPerfilViewModel mViewModel;

    Button btnCrearCuenta;
    EditText txtNombre, txtCorreo,txtContraseña,txtTelefono,txtDireccion;



    public static MiPerfilFragment newInstance() {
        return new MiPerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.mi_perfil_fragment, container, false);

        View view = inflater.inflate(R.layout.mi_perfil_fragment, container, false);

        btnCrearCuenta = (Button) view.findViewById(R.id.btnRegistrar);
        txtNombre = (EditText) view.findViewById(R.id.txtNombre);
        txtCorreo = (EditText) view.findViewById(R.id.txtCorreo);
        txtContraseña = (EditText) view.findViewById(R.id.txtContraseña);
        txtTelefono = (EditText) view.findViewById(R.id.txtTelefono);
        txtDireccion = (EditText) view.findViewById(R.id.txtDireccion);

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean faltanDatos = false;

                String Nombre = txtNombre.getText().toString();
                String Correo = txtCorreo.getText().toString();
                String Contraseña = txtContraseña.getText().toString();
                String Telefono = txtTelefono.getText().toString();
                String Direccion = txtDireccion.getText().toString();

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
        mViewModel = ViewModelProviders.of(this).get(MiPerfilViewModel.class);
        // TODO: Use the ViewModel
    }

}

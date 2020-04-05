package com.example.cateringaleapp.ui.iniciarsesion;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringaleapp.R;

public class IniciarSesion extends Fragment {

    private IniciarSesionViewModel mViewModel;

    public static IniciarSesion newInstance() {
        return new IniciarSesion();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.iniciar_sesion_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IniciarSesionViewModel.class);
        // TODO: Use the ViewModel
    }

}

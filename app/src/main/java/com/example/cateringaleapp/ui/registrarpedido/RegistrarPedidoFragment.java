package com.example.cateringaleapp.ui.registrarpedido;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringaleapp.R;

public class RegistrarPedidoFragment extends Fragment {

    private RegistrarPedidoViewModel mViewModel;

    public static RegistrarPedidoFragment newInstance() {
        return new RegistrarPedidoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registrar_pedido_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegistrarPedidoViewModel.class);
        // TODO: Use the ViewModel
    }

}

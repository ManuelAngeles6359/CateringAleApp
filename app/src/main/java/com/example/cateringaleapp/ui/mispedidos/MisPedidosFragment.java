package com.example.cateringaleapp.ui.mispedidos;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringaleapp.R;

public class MisPedidosFragment extends Fragment {

    private MisPedidosViewModel mViewModel;

    public static MisPedidosFragment newInstance() {
        return new MisPedidosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mis_pedidos_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MisPedidosViewModel.class);
        // TODO: Use the ViewModel
    }

}

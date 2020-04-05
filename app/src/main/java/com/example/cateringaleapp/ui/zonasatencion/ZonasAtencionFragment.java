package com.example.cateringaleapp.ui.zonasatencion;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringaleapp.R;

public class ZonasAtencionFragment extends Fragment {

    private ZonasAtencionViewModel mViewModel;

    public static ZonasAtencionFragment newInstance() {
        return new ZonasAtencionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.zonas_atencion_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ZonasAtencionViewModel.class);
        // TODO: Use the ViewModel
    }

}

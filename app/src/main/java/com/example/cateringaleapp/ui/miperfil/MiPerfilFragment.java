package com.example.cateringaleapp.ui.miperfil;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringaleapp.R;

public class MiPerfilFragment extends Fragment {

    private MiPerfilViewModel mViewModel;

    public static MiPerfilFragment newInstance() {
        return new MiPerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mi_perfil_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MiPerfilViewModel.class);
        // TODO: Use the ViewModel
    }

}

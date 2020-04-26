package com.example.cateringaleapp.ui.Adaptadores;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cateringaleapp.ui.Entidades.DetallePedido;

import java.util.List;
import com.example.cateringaleapp.R;


public class DetallePedidoNuevoAdapter extends RecyclerView.Adapter<DetallePedidoNuevoAdapter.MyViewHolder> {

    private List<DetallePedido> detallePedidoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView Nombre, Precio, Cantidad;

        public MyViewHolder(View view) {
            super(view);
            Nombre = (TextView) view.findViewById(R.id.Nombre);
            Precio = (TextView) view.findViewById(R.id.Precio);
            Cantidad = (TextView) view.findViewById(R.id.Cantidad);
        }
    }


    public DetallePedidoNuevoAdapter(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detalle_fila, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DetallePedido detallePedido = detallePedidoList.get(position);
        holder.Nombre.setText(detallePedido.getNombre());
        holder.Precio.setText(detallePedido.getPrecio().toString());
        holder.Cantidad.setText(detallePedido.getCantidad().toString());


    }

    @Override
    public int getItemCount() {
        return detallePedidoList.size();
    }


}

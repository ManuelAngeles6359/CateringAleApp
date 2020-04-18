package com.example.cateringaleapp.ui.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cateringaleapp.ui.Entidades.Producto;
import com.example.cateringaleapp.R;

import java.util.List;



public class ProductoAdapter extends ArrayAdapter<Producto> {

    String name=null;

    public List<Producto> list;

    public ProductoAdapter(Context context, List<Producto> objects) {
        super(context, 0, objects);
        list = objects;
    }

    @Override
    public Producto getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;


        if (null == convertView)
        {

            convertView = inflater.inflate(R.layout.lista_productos,parent,false);

            holder = new ViewHolder();
            holder.imgFoto = (ImageView) convertView.findViewById(R.id.imgFoto);
            holder.txtNombre = (TextView) convertView.findViewById(R.id.txtNombre);
            holder.txtPrecio = (TextView) convertView.findViewById(R.id.txtPrecio);
            holder.txtEnPromocion=(TextView) convertView.findViewById(R.id.txtEnPromocion);

            convertView.setTag(holder);

        }else{
            holder= (ViewHolder)convertView.getTag();
        }


        Producto pro = getItem(position);

        holder.txtNombre.setText(pro.getNombre());
        holder.txtPrecio.setText(pro.getPrecio().toString());
        holder.txtEnPromocion.setText(pro.getEnPromocion());

        return convertView;
    }

    static class ViewHolder {

        ImageView imgFoto;
        TextView txtNombre;
        TextView txtPrecio;
        TextView txtEnPromocion;

    }
}

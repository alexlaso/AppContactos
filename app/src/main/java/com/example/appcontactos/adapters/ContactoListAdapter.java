package com.example.appcontactos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.appcontactos.R;
import com.example.appcontactos.infoContactos.Contacto;

public class ContactoListAdapter extends ListAdapter<Contacto, ContactoViewHolder>{

    public ContactoListAdapter(@NonNull DiffUtil.ItemCallback<Contacto> diffCallBack){
        super(diffCallBack);
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_vista_unidad, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto actual = getItem(position);
        holder.editTextNombreNuevo.setText(actual.getNombre().toString());
        holder.editTextNumTel.setText(actual.getNum_uno());
        holder.editTextEmail.setText(actual.getEmail().toString());
        holder.editTextDir.setText(actual.getDireccion().toString());
    }

    public static class ContactoDiff extends DiffUtil.ItemCallback<Contacto>{
        @Override
        public boolean areItemsTheSame(@NonNull Contacto oldItem, @NonNull Contacto newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contacto oldItem, @NonNull Contacto newItem) {
            return oldItem.toString().equals(newItem.toString());
        }
    }
}

package com.example.appcontactos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcontactos.R;
import com.example.appcontactos.infoContactos.Contacto;

import java.util.List;

public class ContactoAdapterRecyclerView extends RecyclerView.Adapter<ContactoViewHolder> {
    private List<Contacto> listaContactos;
    public ContactoAdapterRecyclerView (List<Contacto> lista){this.listaContactos=lista;}

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_vista_unidad, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position){
        holder.editTextNombreNuevo.setText(listaContactos.get(position).getNombre());
        holder.editTextNumTel.setText(listaContactos.get(position).getNum_uno());
        holder.editTextEmail.setText(listaContactos.get(position).getEmail());
        holder.editTextDir.setText(listaContactos.get(position).getDireccion());
    }

    @Override
    public int getItemCount(){return listaContactos.size();}
}

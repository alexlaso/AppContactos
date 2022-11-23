package com.example.appcontactos.adapters;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcontactos.R;

public class ContactoViewHolder extends RecyclerView.ViewHolder  {
    public EditText editTextNombreNuevo, editTextNumTel, editTextEmail, editTextDir;

    public ContactoViewHolder(@NonNull View itemView){
        super(itemView);
        editTextNombreNuevo = itemView.findViewById(R.id.editTextNombreNuevo);
        editTextNumTel = itemView.findViewById(R.id.editTextNumTel);
        editTextEmail = itemView.findViewById(R.id.editTextEmail);
        editTextDir = itemView.findViewById(R.id.editTextDir);
    }
}

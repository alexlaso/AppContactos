package com.example.appcontactos.adapters;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcontactos.R;

public class ContactoViewHolder extends RecyclerView.ViewHolder  {
    public TextView editTextNombreNuevo, editTextNumTel, editTextEmail, editTextDir;

    public ContactoViewHolder(@NonNull View itemView){
        super(itemView);
        editTextNombreNuevo = itemView.findViewById(R.id.textViewNombre);
        editTextNumTel = itemView.findViewById(R.id.textViewNumTel);
        editTextEmail = itemView.findViewById(R.id.textViewEmail);
        editTextDir = itemView.findViewById(R.id.textViewDir);
    }
}

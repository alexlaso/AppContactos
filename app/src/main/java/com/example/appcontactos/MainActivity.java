package com.example.appcontactos;

import android.content.Intent;
import android.os.Bundle;

import com.example.appcontactos.adapters.ContactoListAdapter;
import com.example.appcontactos.infoContactos.Contacto;
import com.example.appcontactos.viewModel.ContactoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaContactos;
    ContactoViewModel contactoViewModel;
    FloatingActionButton btnAdd;
    public static final int REQUEST_CODE_NUEVO_CONTACTO=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view ->{
                lanzarNuevoContacto();
        });

        listaContactos = findViewById(R.id.listaContactos);
        final ContactoListAdapter adapter = new ContactoListAdapter(new ContactoListAdapter.ContactoDiff());
        listaContactos.setLayoutManager(new LinearLayoutManager(this));
        listaContactos.setAdapter(adapter);

        contactoViewModel = new ViewModelProvider(this).get(ContactoViewModel.class);
        contactoViewModel.getTodosLosContactos().observe(this, contactos -> {
            adapter.submitList(contactos);
        });
    }

    private void lanzarNuevoContacto(){
        Intent intent =new Intent(MainActivity.this, NuevoContacto.class);
        startActivityForResult(intent, REQUEST_CODE_NUEVO_CONTACTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_NUEVO_CONTACTO && resultCode == RESULT_OK){
            Contacto nuevoContacto = new Contacto(data.getStringExtra("nombre"),data.getIntExtra("num_uno", 000000000), data.getStringExtra("email"), data.getStringExtra("direccion"));

             contactoViewModel.insertarNuevoContacto(nuevoContacto);
        }else{
            Toast.makeText(getApplicationContext(), "Error, faltan datos", Toast.LENGTH_SHORT).show();
        }
    }
}
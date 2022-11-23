package com.example.appcontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NuevoContacto extends AppCompatActivity {
    EditText editTextNombreNuevo, editTextNumTel, editTextEmail, editTextDir;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        editTextNombreNuevo = findViewById(R.id.editTextNombreNuevo);
        editTextNumTel = findViewById(R.id.editTextNumTel);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextDir = findViewById(R.id.editTextDir);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(view -> guardarContacto());
    }

    private void guardarContacto(){
        Intent intentRespuesta = new Intent();
        if(algunoEstaVacio()){
            setResult(RESULT_CANCELED);
        }
        else{
            prepararContacto(intentRespuesta);
    }
        finish();
}

    private void prepararContacto(Intent intentRespuesta){
        intentRespuesta.putExtra("nombre", editTextNombreNuevo.getText().toString());
        intentRespuesta.putExtra("num_uno", editTextNumTel.getText().toString());
        intentRespuesta.putExtra("email", Integer.valueOf(editTextNumTel.getText().toString()));
        intentRespuesta.putExtra("direccion", editTextDir.getText().toString());

        setResult(RESULT_OK, intentRespuesta);
    }

    private boolean algunoEstaVacio(){
        return TextUtils.isEmpty(editTextNombreNuevo.getText()) || TextUtils.isEmpty(editTextNumTel.getText()) || TextUtils.isEmpty(editTextEmail.getText()) || TextUtils.isEmpty(editTextDir.getText());
    }
}
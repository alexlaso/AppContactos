package com.example.appcontactos;

import android.content.Intent;
import android.os.Bundle;

import com.example.appcontactos.infoContactos.Contacto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcontactos.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaContactos;
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        }
    }
}
package com.example.appcontactos.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.appcontactos.infoContactos.Contacto;
import com.example.appcontactos.repositorios.RepositorioContactosDB;

import java.util.List;

public class ContactoViewModel extends AndroidViewModel {
    private RepositorioContactosDB repositorioContactosDB;
    private LiveData<List<Contacto>> todosLosContactos;

    public ContactoViewModel(@NonNull Application application) {
        super(application);
        repositorioContactosDB = new RepositorioContactosDB(application);
        todosLosContactos = repositorioContactosDB.getTodosLosContactos();
    }

    public LiveData<List<Contacto>> getTodosLosContactos(){return todosLosContactos;}

    public void insertarNuevoContacto(Contacto contacto){
        repositorioContactosDB.insertarContacto(contacto);
    }
}

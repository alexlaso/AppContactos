package com.example.appcontactos.repositorios;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.appcontactos.infoContactos.BaseDatosContactos;
import com.example.appcontactos.infoContactos.Contacto;
import com.example.appcontactos.infoContactos.ContactoDAO;

import java.util.List;

public class RepositorioContactosDB {
    private ContactoDAO contactoDAO;
    private LiveData<List<Contacto>> todosLosContactos;

    public RepositorioContactosDB(Application app){
        BaseDatosContactos baseDatosContactos = BaseDatosContactos.getBaseDatosContactos(app);
        contactoDAO = baseDatosContactos.contactoDAO();
        todosLosContactos = contactoDAO.seleccionarTablaContactos();
        generarGenerico();
    }

    public LiveData<List<Contacto>> getTodosLosContactos(){return todosLosContactos;}

    public void insertarContacto(Contacto nuevoContacto){
        BaseDatosContactos.baseDatosEscritor.execute(()->contactoDAO.insert(nuevoContacto));
    }

    public void borrarContacto(Contacto contacto){
        BaseDatosContactos.baseDatosEscritor.execute(()->contactoDAO.borrarContacto(contacto));
    }

    public void actualizarContacto(Contacto contacto){
        BaseDatosContactos.baseDatosEscritor.execute(()->contactoDAO.updateContacto(contacto));
    }

    public void generarGenerico(){Contacto contacto = new Contacto("Pancracio", 123456789, "pancracio@hotmail.com", "Villa de la diversión 3 2ºDerecha");}
}

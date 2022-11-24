package com.example.appcontactos.infoContactos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactoDAO {
    @Insert
    void insert(Contacto contacto);

    @Query("SELECT * FROM contactos_tabla ORDER BY id desc")
    LiveData<List<Contacto>> seleccionarTablaContactos();

    @Query("DELETE FROM contactos_tabla")
    void borrarTodo();

    @Delete
    void borrarContacto(Contacto contacto);

    @Update
    void updateContacto(Contacto contacto);
}

package com.example.appcontactos.infoContactos;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contacto.class}, version = 1, exportSchema = false)
public abstract class BaseDatosContactos extends RoomDatabase{
    private static final String DB_NAME = "contactos_ddbb";

    public abstract ContactoDAO contactoDAO();

    private static final int NUM_THREADS = 4;
    public static final ExecutorService baseDatosEscritor = Executors.newFixedThreadPool(NUM_THREADS);

    public static volatile BaseDatosContactos INSTANCE;

    public static BaseDatosContactos getBaseDatosContactos(final Context context){
        if (INSTANCE == null){
            synchronized (BaseDatosContactos.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BaseDatosContactos.class, DB_NAME).addCallback(callbackContactos).build();
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback callbackContactos = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            baseDatosEscritor.execute(()->{
            ContactoDAO dao = INSTANCE.contactoDAO();
            dao.borrarTodo();
            dao.insert(new Contacto("Pancracio", 123456789, "pancracio@hotmail.com", "Avenida de la esquina, portal 1, bajo 4"));
        });
    }

};
    }

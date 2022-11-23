package com.example.appcontactos.infoContactos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;
import java.io.Serializable;

@Entity(tableName="contactos_tabla")
public class Contacto implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="nombre")
    private String nombre;

    @ColumnInfo(name="num_uno")
    private int num_uno;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="direccion")
    private String direccion;

    public Contacto(String nombre, int num_uno, String email, String direccion) {
        this.nombre = nombre;
        this.num_uno = num_uno;
        this.email = email;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", num_uno=" + num_uno +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_uno() {
        return num_uno;
    }

    public void setNum_uno(int num_uno) {
        this.num_uno = num_uno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

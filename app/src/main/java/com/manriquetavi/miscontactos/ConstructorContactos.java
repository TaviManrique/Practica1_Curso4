package com.manriquetavi.miscontactos;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorContactos {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        /*
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Tavi Manrique","+51 9584708","u201412767@upc.edu.pe", R.drawable.photo,0));
        contactos.add(new Contacto("Edxel Jogues","+51 902641002","u20191a369@upc.edu.pe", R.drawable.photo,0));
        contactos.add(new Contacto("Rodrigo Eyzaguirre","+51 992904564","u201411182@upc.edu.pe", R.drawable.photo,0));
        contactos.add(new Contacto("Samuel Calixto","+51 942874148","u20151B709@upc.edu.pe", R.drawable.photo,0));
        contactos.add(new Contacto("Bryan Sandoval","+51 941919843","u201510423@upc.edu.pe", R.drawable.photo,0));
        return contactos;*/
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosContactos();
    }

    public void insertarTresContactos(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_NOMBRE, "Tavi Manrique");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_TELEFONO, "958574708");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_EMAIL, "tavidanner96@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_FOTO, R.drawable.photo);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_ID,1);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_NOMBRE, "Rodri Rodri");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_TELEFONO, "992904564");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_EMAIL, "u201411182@upc.edu.pe");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_FOTO, R.drawable.photo);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_ID,2);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_NOMBRE, "Edxel Jogues");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_TELEFONO, "902641002");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_EMAIL, "u20191a369@upc.edu.pe");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_FOTO, R.drawable.photo);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTOS_ID,3);

        db.insertarContactos(contentValues);
    }

    public void darLikeContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTO_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTO_NUMERO_LIKES, LIKE);
        db.insertarLikeContactos(contentValues);
    }

    public int obtenerLikeContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikeContacto(contacto);
    }
}

package com.manriquetavi.miscontactos;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context ) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE IF NOT EXISTS " + ConstantesBaseDatos.TABLE_CONTACTOS + "(" +
                ConstantesBaseDatos.TABLE_CONTACTOS_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_CONTACTOS_NOMBRE      + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTOS_TELEFONO    + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTOS_EMAIL       + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTOS_FOTO        + " INTEGER" +
                ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE IF NOT EXISTS " + ConstantesBaseDatos.TABLE_LIKES_CONTACTO + "(" +
                ConstantesBaseDatos.TABLE_LIKES_CONTACTO_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACTO_ID_CONTACTO    + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACTO_NUMERO_LIKES   + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_CONTACTO_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTOS + "(" + ConstantesBaseDatos.TABLE_CONTACTOS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_CONTACTOS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_CONTACTO);
        onCreate(db);

    }

    public ArrayList<Contacto> obtenerTodosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //Para recorrer los registro
        while (cursor.moveToNext()) {
            /*
            Contacto contactoActual = new Contacto();
            contactoActual.setId(cursor.getInt(0));
            contactoActual.setNombre(cursor.getString(1));
            contactoActual.setCelular(cursor.getString(2));
            contactoActual.setEmail(cursor.getString(3));
            contactoActual.setFoto(cursor.getInt(4));
            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_CONTACTO_NUMERO_LIKES + ") as likes" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACTO +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTO_ID_CONTACTO + "=" + contactoActual.getId();
            Cursor cursorLikes = db.rawQuery(queryLikes, null);
            if (cursorLikes.moveToNext()) {
                contactoActual.setLikes(cursorLikes.getInt(0));
            }
            else {
                contactoActual.setLikes(0);
            }
            contactos.add(contactoActual);
             */
        }
        db.close();
        return contactos;
    }

    public void insertarContactos(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTOS, null, contentValues);
        db.close();
    }

    public void insertarLikeContactos(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACTO, null, contentValues);
        db.close();
    }

    public int obtenerLikeContacto(Contacto contacto) {
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_CONTACTO_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACTO +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTO_ID_CONTACTO + "=" + contacto.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToNext()) {
            likes = cursor.getInt(0);
        }
        db.close();
        return likes;
    }
}

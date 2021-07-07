package com.manriquetavi.miscontactos;

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTOS                      = "contacto";
    public static final String TABLE_CONTACTOS_ID                   = "id";
    public static final String TABLE_CONTACTOS_NOMBRE               = "nombre";
    public static final String TABLE_CONTACTOS_TELEFONO             = "telefono";
    public static final String TABLE_CONTACTOS_EMAIL                = "correo";
    public static final String TABLE_CONTACTOS_FOTO                 = "foto";

    public static final String TABLE_LIKES_CONTACTO                 = "contacto_likes";
    public static final String TABLE_LIKES_CONTACTO_ID              = "id";
    public static final String TABLE_LIKES_CONTACTO_ID_CONTACTO     = "id_contacto";
    public static final String TABLE_LIKES_CONTACTO_NUMERO_LIKES    = "numero_likes";
}

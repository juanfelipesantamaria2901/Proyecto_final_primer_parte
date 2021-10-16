package com.example.proyectofinalprimerparte.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Usuarios.db";
    private static final String TABLE_USUARIOS = "t_usuarios";



    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_USUARIOS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cedula TEXT NOT NULL," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "facultad TEXT NOT NULL," +
                "sede TEXT NOT NULL," +
                "programa TEXT NOT NULL," +
                "rol TEXT NOT NULL," +
                "usuario TEXT NOT NULL," +
                "contraseña TEXT NOT NULL," +
                "estado TEXT NOT NULL) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_USUARIOS);
        onCreate(sqLiteDatabase);
    }


    public void agregarDatos(String cedula, String nombre, String apellido, String facultad, String sede,
                             String programa,  String rol, String usuario, String contraseña, String estado){
        SQLiteDatabase bd = getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO "+ TABLE_USUARIOS + "VALUES ('"+cedula+"','"+nombre+"','"+apellido+
                    "','"+facultad+"','"+sede+"','"+programa+"','"+rol+"','"+usuario+
                    "','"+contraseña+"','"+estado+"')");
            bd.close();

        }

    }
}

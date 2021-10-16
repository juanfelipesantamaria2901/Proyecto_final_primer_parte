package com.example.proyectofinalprimerparte;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalprimerparte.db.DbHelper;

public class GestionUsuarios extends AppCompatActivity {

    Button btnCrear;
    Button btnUsuario;
    EditText cedula;
    EditText nombre;
    EditText apellido;
    EditText facultad;
    Spinner sede;
    EditText programa;
    Spinner rol;
    EditText usuario;
    EditText contraseña;
    Spinner estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_usuarios);
        btnCrear = findViewById(R.id.button6);
        btnUsuario = findViewById(R.id.button4);
        cedula = (EditText)findViewById(R.id.editTextTextPersonName);
        nombre = (EditText)findViewById(R.id.editTextTextPersonName2);
        apellido = (EditText)findViewById(R.id.editTextTextPersonName3);
        facultad = (EditText)findViewById(R.id.editTextTextPersonName4);
        sede = (Spinner) findViewById(R.id.spinner);
        programa = (EditText)findViewById(R.id.editTextTextPersonName5);
        rol = (Spinner) findViewById(R.id.spinner2);
        usuario = (EditText)findViewById(R.id.editTextTextPersonName6);
        contraseña = (EditText)findViewById(R.id.editTextTextPassword);
        estado = (Spinner) findViewById(R.id.spinner3);


        DbHelper dbHelper = new DbHelper(getApplicationContext());
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db!=null){
                    Toast.makeText(getApplicationContext(),"Creada con exito",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"No se creo la base", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.agregarDatos(cedula.getText().toString(),nombre.getText().toString(),
                        apellido.getText().toString(),facultad.getText().toString(),sede.toString(),
                        programa.getText().toString(),rol.toString(),usuario.getText().toString(),
                        contraseña.getText().toString(),estado.toString());
                Toast.makeText(getApplicationContext(),"Gurdado con exito",Toast.LENGTH_LONG).show();
            }
        });
    }





}
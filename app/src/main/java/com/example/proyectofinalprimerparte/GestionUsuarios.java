package com.example.proyectofinalprimerparte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GestionUsuarios extends AppCompatActivity {
    EditText cedula,nombre,apellido,facultad, programa,usuario,contrasena;
    Spinner spinnerrol,spinnersede,spinnerestado;
    Button btnguardar,btnconsultar,btnmodificar;
    private DatabaseReference Usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_usuarios);
        Usuarios=FirebaseDatabase.getInstance().getReference("Usuarios");
        cedula=(EditText) findViewById(R.id.txtcedula);
        nombre=(EditText) findViewById(R.id.txtnombre);
        apellido=(EditText) findViewById(R.id.txtapellido);
        facultad=(EditText) findViewById(R.id.txtfacultad);
        programa=(EditText) findViewById(R.id.txtprograma);
        usuario=(EditText) findViewById(R.id.txtusuario);
        contrasena=(EditText) findViewById(R.id.txtcontrasena);

        spinnerrol=(Spinner) findViewById(R.id.spinnerrol);
        String[] roles={"estudiante","docente"};
        ArrayAdapter <String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,roles);
        spinnerrol.setAdapter(adapter);

        spinnersede=(Spinner) findViewById(R.id.spinnersede);
        String [] sedes={"principal", "san Fernando", "corregimiento el placer"};
        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sedes);
        spinnersede.setAdapter(adapter2);

        spinnerestado=(Spinner) findViewById(R.id.spinnerestado);
        String [] estados={"activo", "inactivo"};
        ArrayAdapter <String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,estados);
        spinnerestado.setAdapter(adapter3);

        btnguardar=(Button) findViewById(R.id.btnguardar);
        btnconsultar=(Button) findViewById(R.id.btnconsultar);
        btnmodificar=(Button) findViewById(R.id.btnmodificar);

    }

    public void registrarUsuario(View view){
        String rol=spinnerrol.getSelectedItem().toString();
        String sede=spinnersede.getSelectedItem().toString();
        String estado=spinnerestado.getSelectedItem().toString();
        String cc=cedula.getText().toString();
        String nom=nombre.getText().toString();
        String ape=apellido.getText().toString();
        String fac=facultad.getText().toString();
        String prog=programa.getText().toString();
        String usu=usuario.getText().toString();
        String contra=contrasena.getText().toString();

        if(!TextUtils.isEmpty(cc)&&!TextUtils.isEmpty(nom)&&!TextUtils.isEmpty(ape)){
            String id=Usuarios.push().getKey();
            Usuarios usuario =new Usuarios (id,cc,nom,ape,sede,fac,prog,rol,usu,contra,estado);
            Usuarios.child("usuario").child(id).setValue(usuario);
            Toast.makeText(this,"Usuario registrado",Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this,"Debe introducir una cedula",Toast.LENGTH_LONG).show();

    }
}
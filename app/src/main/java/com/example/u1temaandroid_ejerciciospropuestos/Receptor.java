package com.example.u1temaandroid_ejerciciospropuestos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Receptor extends AppCompatActivity {

    TextView txtmesaje;
    String nombre;
    String apellido;
    String grado;
    String sexo;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        apellido = extras.getString("apellido");
        grado = extras.getString("grado");
        sexo = extras.getString("sexo");
        fecha = extras.getString("fecha");

        txtmesaje = findViewById(R.id.txtmensaje);
        txtmesaje.setText("Bienvenido " + nombre + " " + apellido + "\n" +
                "Grado Academico : " + grado + "\n" +
                "Sexo : " + sexo + "\n" +
                "Fecha : " + fecha);
    }
}
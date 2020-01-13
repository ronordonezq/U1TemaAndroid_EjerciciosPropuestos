package com.example.u1temaandroid_ejerciciospropuestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ir_calculadora(View view) {
        startActivity(new Intent(this, Calculadora.class));
    }

    public void ir_formulario(View view) {
        startActivity(new Intent(this, Formulario.class));
    }
}

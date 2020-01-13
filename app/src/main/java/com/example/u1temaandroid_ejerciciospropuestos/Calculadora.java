package com.example.u1temaandroid_ejerciciospropuestos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Calculadora extends AppCompatActivity {

    TextView tvEntrada,tvSalida;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnsuma,btnresta,btndivision,btnmultiplicacion,btnigual,btnlimpiar,btnpunto,btnPorcentaje,btnparentesis;
    String proceso;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        tvEntrada = findViewById(R.id.tvEntrada);
        tvSalida = findViewById(R.id.tvResultado);

        btnsuma = findViewById(R.id.btnSumar);
        btnresta = findViewById(R.id.btnRestar);
        btndivision = findViewById(R.id.btnDividir);
        btnmultiplicacion = findViewById(R.id.btnMultiplicar);


        btnigual = findViewById(R.id.btnIgual);
        btnlimpiar = findViewById(R.id.btnLimpiar);
        btnpunto = findViewById(R.id.btnPunto);
        btnPorcentaje = findViewById(R.id.btnPorcentaje);
        btnparentesis = findViewById(R.id.btnParentesis);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);


        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEntrada.setText("");
                tvSalida.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "9");
            }
        });

        btnsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "+");
            }
        });

        btnresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "-");
            }
        });

        btnmultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "x");
            }
        });

        btndivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "/");
            }
        });


        btnpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + ".");
            }
        });

        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "%");
            }
        });

        btnparentesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkBracket == true){
                    proceso = tvEntrada.getText().toString();
                    tvEntrada.setText(proceso + ")");
                    checkBracket = false;
                }else {
                    proceso = tvEntrada.getText().toString();
                    tvEntrada.setText(proceso + "(");
                    checkBracket = true;
                }
            }
        });

        btnigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();
                proceso = proceso.replaceAll("x","*");
                proceso = proceso.replaceAll("%","/100");
                proceso = proceso.replaceAll("/","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,proceso,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }
                tvSalida.setText(finalResult);
            }
        });

    }
}

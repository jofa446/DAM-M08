package com.example.principal;

import static com.example.principal.R.id.textimput;

import android.os.Bundle;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextView textimput;
    private TextView textimput2;
    private TextView textView;
    private Button sumar;
    private Button restar;
    private Button multiplicar;
    private Button dividir;
    private String operador;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumar = findViewById(R.id.sumar);
        restar = findViewById(R.id.restar);
        multiplicar = findViewById(R.id.multiplicar);
        dividir = findViewById(R.id.dividir);
        textimput = findViewById(R.id.textimput);
        textimput2 = findViewById(R.id.textimput2);
        textView = findViewById(R.id.textView);


        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "+";
                operacio();
            }
        });
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "-";
                operacio();
            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "*";
                operacio();
            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (1==1){

                }
                operador = "/";
                operacio();
            }
        });


    }

    private void operacio(){
        try {
            double numero1 = Double.parseDouble(textimput.getText().toString());
            double numero2 = Double.parseDouble(textimput2.getText().toString());
            double resultat = 0.0;

            switch (operador) {
                case "+":
                    resultat = numero1 + numero2;
                    break;
                case "-":
                    resultat = numero1 - numero2;
                    break;
                case "*":
                    resultat = numero1 * numero2;
                    break;
                case "/":
                    if (numero2 == 0) {
                        Toast.makeText(this, "No es pot dividir per 0", Toast.LENGTH_SHORT).show();
                    } else {
                        resultat = numero1 / numero2;

                    }
                    break;
            }

            textView.setText(String.valueOf(resultat));
        } catch (NumberFormatException e) {
            // Control de error para entradas no válidas
            Toast.makeText(this, "Ingresa nombres valids", Toast.LENGTH_SHORT).show();
        }

    }

}
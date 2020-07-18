package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnVerdadero;
    private Button btnFalso;
    private Button btnSiguiente;
    private Button btnAnterior;
    private Button btnTrampa;
    private TextView tvPregunta;

    private Pregunta[] preguntas = new Pregunta[]{
            new Pregunta(R.string.pregunta_1, true),
            new Pregunta(R.string.pregunta_2, true),
            new Pregunta(R.string.pregunta_3, true),
            new Pregunta(R.string.pregunta_4, true),
            new Pregunta(R.string.pregunta_5, false)
    };

    private int actual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVerdadero = (Button) findViewById(R.id.true_button);
        btnFalso = (Button) findViewById(R.id.false_button);
        btnAnterior = (Button) findViewById(R.id.previous_button);
        btnSiguiente = (Button) findViewById(R.id.following_button);
        btnTrampa = (Button) findViewById(R.id.respuesta_button);
        tvPregunta = (TextView) findViewById(R.id.pregunta_text);

        setText();

        btnVerdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(true);
            }
        });

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(false);
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (actual == 0) {
                    actual = preguntas.length - 1;
                } else {
                    actual--;
                }

                setText();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actual = (actual + 1) % preguntas.length;
                setText();
            }
        });

        btnTrampa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=preguntas[actual].isRespuesta();
                Intent i = TrampaActivity.newIntent(MainActivity.this,result);
                startActivity(i);
            }
        });
    }

    public void setText() {
        tvPregunta.setText(preguntas[actual].getTextoId());
    }

    public void verificarRespuesta(boolean result) {
        if (result == preguntas[actual].isRespuesta()) {
            Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}
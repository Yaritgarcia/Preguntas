package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TrampaActivity extends AppCompatActivity {

    public static final String EXTRA_RESPUESTA = "com.example.geoquiz.respuesta";
    private Button btnAceptar;
    private Button btnVolver;
    private TextView txtResputa;
    private boolean result;


    public static Intent newIntent(Context context, boolean esCorrecto) {
        Intent intent = new Intent(context, TrampaActivity.class);
        intent.putExtra(EXTRA_RESPUESTA, esCorrecto);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trampa);
        // boolean result = getIntent().getBooleanExtra("respuesta", false);
        btnAceptar = (Button) findViewById(R.id.true_button);
        btnVolver = (Button) findViewById(R.id.false_button);
        txtResputa = (TextView) findViewById(R.id.respuesta_text);

        result = getIntent().getBooleanExtra(EXTRA_RESPUESTA, false);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResputa.setVisibility(View.VISIBLE);
                if (result) {
                    txtResputa.setText(R.string.verdadero_txt);
                } else {
                    txtResputa.setText(R.string.falsa_txt);
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResputa.setVisibility(View.INVISIBLE);
                Intent i = MainActivity.newIntent(TrampaActivity.this);
                startActivity(i);
            }
        });


    }
}
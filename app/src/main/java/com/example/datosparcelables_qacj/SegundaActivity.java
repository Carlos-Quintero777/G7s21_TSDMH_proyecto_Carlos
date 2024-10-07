package com.example.datosparcelables_qacj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {

    private TextView lblAceptado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        lblAceptado = findViewById(R.id.lblEnviado);
        Intent intent = getIntent();
        Usuario usuario = intent.getParcelableExtra("usuario");
        if (usuario != null) {
            lblAceptado.setText("¡Hola! Mi buen " + usuario.getNombre());
        }

        Button btnCaptura = findViewById(R.id.btncaptura);
        btnCaptura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCaptura = new Intent(SegundaActivity.this, CapturaActivity.class);
                startActivity(intentCaptura);
            }
        });

        Button btnMostrar = findViewById(R.id.btnmostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMostrar = new Intent(SegundaActivity.this, ParcelableActivity.class);
                intentMostrar.putExtra("usuario", usuario);
                startActivity(intentMostrar);
            }
        });

        Button btnTerminar = findViewById(R.id.btnterminar);
        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}

package com.example.datosparcelables_qacj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ParcelableActivity extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewEdad;
    private TextView textViewCorreo;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Usuario usuario = getIntent().getParcelableExtra("usuario");

        if (usuario == null) {
            Intent intentRechazado = new Intent(ParcelableActivity.this, RechazadoActivity.class);
            startActivity(intentRechazado);
            finish();
            return;
        }

        setContentView(R.layout.activity_parcelable);
        textViewNombre = findViewById(R.id.textViewNombre);
        textViewEdad = findViewById(R.id.textViewEdad);
        textViewCorreo = findViewById(R.id.textViewCorreo);


        textViewNombre.setText(usuario.getNombre());
        textViewEdad.setText(usuario.getEdad());
        textViewCorreo.setText(usuario.getCorreo());

        btnInicio = findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegresar = new Intent(ParcelableActivity.this, SegundaActivity.class);
                startActivity(intentRegresar);
                finish();
            }
        });
    }
}

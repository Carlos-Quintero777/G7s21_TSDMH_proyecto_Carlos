package com.example.datosparcelables_qacj;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CapturaActivity extends AppCompatActivity {

    private EditText lblnombre, lbledad, lblcorreo;
    private Button btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        lblnombre = findViewById(R.id.lblnombre);
        lbledad = findViewById(R.id.lbledad);
        lblcorreo = findViewById(R.id.lblcorreo);
        btnregresar = findViewById(R.id.btnregresar);

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = lblnombre.getText().toString().trim();
                String edad = lbledad.getText().toString().trim();
                String correo = lblcorreo.getText().toString().trim();
                if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(edad) || TextUtils.isEmpty(correo)) {
                    Toast.makeText(CapturaActivity.this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Usuario usuario = new Usuario(nombre, edad, correo);
                    Intent intent = new Intent(CapturaActivity.this, SegundaActivity.class);
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}

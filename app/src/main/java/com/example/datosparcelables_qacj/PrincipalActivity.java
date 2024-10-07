package com.example.datosparcelables_qacj;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;  // Importa Handler
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PrincipalActivity.this, SegundaActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}

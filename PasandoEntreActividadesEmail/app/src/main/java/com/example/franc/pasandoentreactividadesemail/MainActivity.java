package com.example.franc.pasandoentreactividadesemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etAsunto;
    EditText etMensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAsunto = (EditText) findViewById(R.id.etAsunto);
        etMensaje = (EditText) findViewById(R.id.etMensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String asunto = etAsunto.getText().toString();
                String mensaje = etMensaje.getText().toString();

                Intent emailenvio = new Intent(Intent.ACTION_SEND);
                emailenvio.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                emailenvio.putExtra(Intent.EXTRA_SUBJECT, asunto);
                emailenvio.putExtra(Intent.EXTRA_TEXT, mensaje);
                emailenvio.setType("message/rfc822");
                startActivity(Intent.createChooser(emailenvio, "Enviar correo por:"));

            }
        });


    }


}

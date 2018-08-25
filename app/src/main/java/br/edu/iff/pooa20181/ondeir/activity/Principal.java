package br.edu.iff.pooa20181.ondeir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.edu.iff.pooa20181.ondeir.R;

public class Principal extends AppCompatActivity{


    private Button btPrincipal;
    private Button btEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);



        btPrincipal = findViewById(R.id.btPrincipal);
        btEventos = findViewById(R.id.btEventos);

        btPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Principal.this, ListaTarefa.class);

                startActivity(intent);
            }
        });

        btEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, ListaLocal.class);
                startActivity(intent);
            }
        });
    }

}

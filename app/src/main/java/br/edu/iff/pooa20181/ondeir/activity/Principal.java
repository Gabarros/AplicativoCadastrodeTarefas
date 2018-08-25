package br.edu.iff.pooa20181.ondeir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import br.edu.iff.pooa20181.ondeir.R;

public class Principal extends AppCompatActivity{

    private String[] activities = {"ListaEvento"};
    private String[] itemMenu = {"Adicionar Tarefas do Dia"};

    private Button btPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemMenu);


        btPrincipal = findViewById(R.id.btPrincipal);

        btPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Principal.this, ListaEvento.class);

                startActivity(intent);
            }
        });
    }

}

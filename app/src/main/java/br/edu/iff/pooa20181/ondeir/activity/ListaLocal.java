package br.edu.iff.pooa20181.ondeir.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.iff.pooa20181.ondeir.R;

public class ListaLocal extends AppCompatActivity implements clickRecyclerViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_local);
    }
}

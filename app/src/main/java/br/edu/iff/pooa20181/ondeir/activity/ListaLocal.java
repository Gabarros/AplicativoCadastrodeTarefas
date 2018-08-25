package br.edu.iff.pooa20181.ondeir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import br.edu.iff.pooa20181.ondeir.R;
import br.edu.iff.pooa20181.ondeir.adapter.ClickRecyclerViewListener;
import br.edu.iff.pooa20181.ondeir.adapter.LocalAdapter;
import br.edu.iff.pooa20181.ondeir.model.Local;
import io.realm.Realm;

public class ListaLocal extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_local);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


        realm = Realm.getDefaultInstance();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaLocal.this, LocalDetalhe.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }

        });
    }


    protected void onResume() {

        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvLocais);

        recyclerView.setAdapter(new LocalAdapter(getLocais(),this, (ClickRecyclerViewListener) this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Local> getLocais(){

        return (List) realm.where(Local.class).findAll();

    }


    @Override
    public void onClick(Object object) {
        Local local = (Local) object;
        Intent intent = new Intent(ListaLocal.this,LocalDetalhe.class);
        intent.putExtra("id",local.getId());
        startActivity(intent);
    }


    public void finish(){
        super.finish();
        realm.close();


    }



}

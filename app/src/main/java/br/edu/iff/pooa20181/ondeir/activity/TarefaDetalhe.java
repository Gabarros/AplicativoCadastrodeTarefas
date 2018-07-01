package br.edu.iff.pooa20181.ondeir.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.iff.pooa20181.ondeir.R;
import br.edu.iff.pooa20181.ondeir.model.Evento;
import io.realm.Realm;

public class TarefaDetalhe extends AppCompatActivity {

    EditText etNome, etDuracao, etData;

    Button btsalvar,btalterar, btdeletar;

    int id;
    Evento evento;
    private Realm realm;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_detalhe);

        etNome = (EditText)findViewById(R.id.etNome);
        etDuracao = (EditText)findViewById(R.id.etDuracao);
        etData = (EditText)findViewById(R.id.etData);

        btsalvar = (Button) findViewById(R.id.bt_salvar_evento);
        btalterar = (Button) findViewById(R.id.bt_alterar_evento);
        btdeletar = (Button) findViewById(R.id.bt_deletar_evento);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            evento = realm.where(Evento.class).equalTo("id",id).findFirst();


            etNome.setText(evento.getNome());
            etDuracao.setText(evento.getDuracao());
            etData.setText(formato.format((Date) evento.getData()));

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        evento.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Evento.class).max("id") !=null)
            proximoID = realm.where(Evento.class).max("id").intValue()+1;

        realm.beginTransaction();
        Evento evento = new Evento();
        evento.setId(proximoID);
        setEGrava(evento);

        realm.copyToRealm(evento);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    private void setEGrava(Evento evento){

        evento.setNome(etNome.getText().toString());
        evento.setDuracao(etDuracao.getText().toString());



        try {
            evento.setData((Date) formato.parse(etData.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
    public void alterar() {

        realm.beginTransaction();

        setEGrava(evento);

        realm.copyToRealm(evento);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }


}

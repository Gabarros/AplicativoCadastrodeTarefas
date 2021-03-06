package br.edu.iff.pooa20181.ondeir.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.iff.pooa20181.ondeir.R;
import br.edu.iff.pooa20181.ondeir.model.Evento;

public class TarefaAdapter extends RecyclerView.Adapter {

    private List<Evento> eventos;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public TarefaAdapter(List<Evento> eventos, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {
        this.eventos = eventos;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_tarefa_cv, parent, false);
        EventoViewHolder eventoViewHolder = new EventoViewHolder(view);
        return eventoViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        EventoViewHolder eventoHolder = (EventoViewHolder) viewHolder;

        Evento evento  = this.eventos.get(position) ;

        DateFormat formato = new SimpleDateFormat("dd/MM");


        eventoHolder.nomeEvento.setText(evento.getNome());
        eventoHolder.dataEvento.setText(formato.format(evento.getData()));
        eventoHolder.categoriaEvento.setText(String.valueOf(evento.getCategoria()));


    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public class EventoViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeEvento;
        private final TextView dataEvento;
        private final TextView categoriaEvento;


        public EventoViewHolder(View itemView) {
            super(itemView);
            nomeEvento = (TextView) itemView.findViewById(R.id.tvNomeTarefa);
            dataEvento = (TextView) itemView.findViewById(R.id.tvDataTarefa);
            categoriaEvento = (TextView) itemView.findViewById(R.id.tvCategoriaTarefa);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(eventos.get(getLayoutPosition()));

                }
            });


        }
    }
}
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
import br.edu.iff.pooa20181.ondeir.model.Local;

public class LocalAdapter extends RecyclerView.Adapter {

    private List<Local> locais;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;


    public LocalAdapter(List<Local> locais, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {
        this.locais = locais;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_tarefa_cv, parent, false);
        LocalViewHolder localViewHolder = new LocalViewHolder(view);
        return localViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        LocalViewHolder localHolder = (LocalViewHolder) viewHolder;

        Local local  = this.locais.get(position) ;


        localHolder.nomeLocal.setText(local.getNome());

    }
    @Override
    public int getItemCount() {
        return locais.size();
    }

    public class LocalViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeLocal;



        public LocalViewHolder(View itemView) {
            super(itemView);
            nomeLocal = (TextView) itemView.findViewById(R.id.tvNomeTarefa);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(locais.get(getLayoutPosition()));

                }
            });


        }
    }
}
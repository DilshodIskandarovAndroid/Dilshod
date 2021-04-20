package com.example.onezero;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>

{
    ArrayList<Model> mList;
    Context context;

    public Adapter(Context context, ArrayList<Model> mList)
    {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Model model = mList.get(position);
        holder.Nomi.setText(model.getNomi());
        holder.faoliyati.setText(model.getFaoliyati());
        holder.manzili.setText(model.getManzili());
        holder.raqami.setText(model.getRaqami());
        holder.joylashuvi.setText(model.getJoylashuvi());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent iintent = new Intent(context, Activity_pars_data.class);
                iintent.putExtra("nomi",model.getNomi());
                iintent.putExtra("faoliyati",model.getFaoliyati());
                iintent.putExtra("manzili",model.getManzili());
                iintent.putExtra("raqami",model.getRaqami());
                iintent.putExtra("joylashuvi",model.getJoylashuvi());
                iintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(iintent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Nomi, faoliyati, manzili, raqami, joylashuvi;

        public ViewHolder(View itemView)
        {
            super(itemView);
            Nomi = itemView.findViewById(R.id.Nomi);
            faoliyati = itemView.findViewById(R.id.faoliyati);
            manzili = itemView.findViewById(R.id.manzili);
            raqami = itemView.findViewById(R.id.raqami);
            joylashuvi = itemView.findViewById(R.id.joylashuvi);
        }
    }
}

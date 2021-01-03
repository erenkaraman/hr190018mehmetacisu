package com.mehmet.hr190018_mehmet_acisu_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mehmet.hr190018_mehmet_acisu_final.model.FutbolcuModel;
import com.mehmet.hr190018_mehmet_acisu_final.util.GlideUtil;
import com.mehmet.hr190018_mehmet_acisu_final.R;

import java.util.List;

public class FutbolcuAdaptor extends RecyclerView.Adapter<FutbolcuViewHolder> {


    List<FutbolcuModel> futbolcular;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public FutbolcuAdaptor(List<FutbolcuModel> futbolcular, Context context, OnItemClickListener listener) {
        this.futbolcular = futbolcular;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FutbolcuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_futbolcu,parent,false);
        return new FutbolcuViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FutbolcuViewHolder viewHolder, int position) {

        viewHolder.txtAdSoyad.setText(futbolcular.get(position).getFutbolcuAdSoyad());
        viewHolder.txtTakim.setText(futbolcular.get(position).getOynadigiTakim());
        viewHolder.txtDogumTarihi.setText(futbolcular.get(position).getDogumTarihi());
        GlideUtil.resmiIndiripGoster(context,futbolcular.get(position).getKucukLogoUrl(),viewHolder.imgProfil);

    }

    @Override
    public int getItemCount() {
        return futbolcular.size();
    }
}

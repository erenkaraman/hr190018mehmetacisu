package com.mehmet.hr190018_mehmet_acisu_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mehmet.hr190018_mehmet_acisu_final.R;


public class FutbolcuViewHolder extends RecyclerView.ViewHolder {

    ImageView imgProfil;
    TextView txtAdSoyad;
    TextView txtTakim;
    TextView txtDogumTarihi;

    public FutbolcuViewHolder(@NonNull View itemView, FutbolcuAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgProfil =itemView.findViewById(R.id.imgProfil);
        txtAdSoyad =itemView.findViewById(R.id.txtAdSoyad);
        txtTakim =itemView.findViewById(R.id.txtTakim);
        txtDogumTarihi=itemView.findViewById(R.id.txtDogumTarihi);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(getAdapterPosition());
            }
        });

    }
}

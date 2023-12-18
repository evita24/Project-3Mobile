package com.example.usingpreferences.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usingpreferences.Activity.FormPerpanjanganDiajukan;
import com.example.usingpreferences.DataModel.ModelStatusPerpanjanganDiajukan;
import com.example.usingpreferences.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class StatusPerpanjanganDiajukanAdapter extends RecyclerView.Adapter<StatusPerpanjanganDiajukanAdapter.ViewHolder> {

    private List<ModelStatusPerpanjanganDiajukan> data;
    public static ShimmerFrameLayout mFrameLayout;
    public static LinearLayout mDataSemua;

    public StatusPerpanjanganDiajukanAdapter(List<ModelStatusPerpanjanganDiajukan> data) {
        if (data == null) {
            this.data = new ArrayList<>();
        } else {
            this.data = data;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_status_perpanjangan_diajukan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       ModelStatusPerpanjanganDiajukan item = data.get(position);


        holder.idPerpanjanganView.setText(item.getId_perpanjangan());
        holder.id_seniman.setText(item.getNama_seniman());
        holder.tglperpanjanganTextView.setText(item.getTgl_pembuatan());

        //ngisor ki gae ketika di klik dia akan nyimpen data ne buat di tampilne nde layout lanjut an e
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Data dari item yang diklik
                String idPerpanjangan = item.getId_perpanjangan();

                // Kirim data ke aktivitas selanjutnya
                Intent intent = new Intent(v.getContext(), FormPerpanjanganDiajukan.class);
                intent.putExtra("id_perpanjangan", idPerpanjangan);
                v.getContext().startActivity(intent);
            }
        });
//selesai
    }



    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView idPerpanjanganView;
        TextView tglperpanjanganTextView;
        TextView id_seniman;
        ShimmerFrameLayout mFrameLayout;

        ViewHolder(View itemView) {
            super(itemView);
            mDataSemua = itemView.findViewById(R.id.data_view);
            mFrameLayout = itemView.findViewById(R.id.shimmer_view);
            idPerpanjanganView = itemView.findViewById(R.id.id_perpanjangan_diajukan);
            tglperpanjanganTextView = itemView.findViewById(R.id.tgl_perpanjangan_diajukan);
            id_seniman = itemView.findViewById(R.id.nama_perpanjangan_diajukan);
        }
    }
}

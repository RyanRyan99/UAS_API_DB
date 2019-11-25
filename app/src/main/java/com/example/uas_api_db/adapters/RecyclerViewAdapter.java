package com.example.uas_api_db.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.uas_api_db.model.animasi;
import com.example.uas_api_db.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext ;
    private List<animasi> mData ;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<animasi> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request Option untuk Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.animasi_row,parent,false) ;


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.tv_nama.setText(mData.get(position).getNama());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_studio.setText(mData.get(position).getStudio());
        holder.tv_kategori.setText(mData.get(position).getKategori());

        //Memuat Gambar cuy dari API

        Glide.with(mContext).load(mData.get(position).getGambar_url()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_nama;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_kategori;
        ImageView img_thumbnail;


        public MyViewHolder(View itemView)
        {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.nama_animasi);
            tv_kategori = itemView.findViewById(R.id.kategori);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_studio = itemView.findViewById(R.id.studio);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }



}

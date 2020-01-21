package com.azwar.sub_2_azwar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azwar.sub_2_azwar.activity.DetailTvShowActivity;
import com.azwar.sub_2_azwar.R;
import com.azwar.sub_2_azwar.model.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.MyViewHolder> {

    private ArrayList<TvShow> tvShows ;

    private Context context;

    public  TvShowAdapter(Context context) {
        this.context = context;
        tvShows = new ArrayList<>();
    }

    public void setTvShows(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TvShow tvShow = tvShows.get(position);
        holder.title.setText(tvShow.getTitle());
        holder.overview.setText(tvShow.getOverview());
        holder.imgPoster.setImageResource(tvShow.getPoster());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToDetail = new Intent(context, DetailTvShowActivity.class);
                moveToDetail.putExtra(DetailTvShowActivity.EXTRA_PERSON, tvShow);
                context.startActivity(moveToDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView overview;
        private ImageView imgPoster;
        
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            overview = itemView.findViewById(R.id.tv_overview);
            imgPoster = itemView.findViewById(R.id.iv_poster);
        }
    }
}

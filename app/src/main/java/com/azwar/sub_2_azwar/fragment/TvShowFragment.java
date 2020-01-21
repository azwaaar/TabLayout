package com.azwar.sub_2_azwar.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azwar.sub_2_azwar.R;
import com.azwar.sub_2_azwar.adapter.TvShowAdapter;
import com.azwar.sub_2_azwar.model.TvShow;

import java.util.ArrayList;

public class TvShowFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<TvShow> tvShows = new ArrayList<>();
    private TvShowAdapter adapter;
    private String[] dataTitle;
    private String[] dataOverview;
    private TypedArray dataPoster;
    private String[] dataStatus;
    private String[] dataCreator;

    public TvShowFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        adapter = new TvShowAdapter(getActivity());
        recyclerView= view.findViewById(R.id.rv_tvshow);

        prepare();
        addItem();
        showTvShow();
        return view;
    }

    private void prepare() {
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_tv);
        dataTitle = getResources().getStringArray(R.array.data_title_tvshow);
        dataStatus = getResources().getStringArray(R.array.data_status);
        dataCreator = getResources().getStringArray(R.array.data_creator_tvshow);
        dataOverview = getResources().getStringArray(R.array.data_ov_tvshow);
    }

    private void addItem() {
        tvShows = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setPoster(dataPoster.getResourceId(i,-1));
            tvShow.setTitle(dataTitle[i]);
            tvShow.setCreator(dataCreator[i]);
            tvShow.setStatus(dataStatus[i]);
            tvShow.setOverview(dataOverview[i]);
            tvShows.add(tvShow);
        }
        adapter.setTvShows(tvShows);
    }

    private void showTvShow() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvShowAdapter movieAdapter = new TvShowAdapter(getActivity());
        movieAdapter.setTvShows(tvShows);
        recyclerView.setAdapter(movieAdapter);
    }
}

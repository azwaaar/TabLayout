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
import com.azwar.sub_2_azwar.adapter.MovieAdapter;
import com.azwar.sub_2_azwar.model.Movie;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieAdapter adapter;
    private String[] dataTitle;
    private String[] dataOverview;
    private TypedArray dataPoster;
    private String[] dataRelease;
    private String[] dataLanguage;

    public MovieFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        adapter = new MovieAdapter(getActivity());

        recyclerView= view.findViewById(R.id.rv_movie);
        recyclerView.setHasFixedSize(true);

        prepare();
        addItem();
        showMovie();
        return view;
    }

    private void prepare() {
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_film);
        dataTitle = getResources().getStringArray(R.array.data_title_film);
        dataRelease = getResources().getStringArray(R.array.data_tahun_film);
        dataLanguage = getResources().getStringArray(R.array.data_bahasa_film);
        dataOverview = getResources().getStringArray(R.array.data_overview_film);
    }
    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i,-1));
            movie.setTitle(dataTitle[i]);
            movie.setRelease(dataRelease[i]);
            movie.setLanguage(dataLanguage[i]);
            movie.setOverview(dataOverview[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
    private void showMovie() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(getActivity());

        movieAdapter.setMovies(movies);
        recyclerView.setAdapter(movieAdapter);
    }
}

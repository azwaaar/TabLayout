package com.azwar.sub_2_azwar.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.azwar.sub_2_azwar.R;
import com.azwar.sub_2_azwar.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    ImageView imgPoster;
    TextView tvTitle;
    TextView tvOverview;
    TextView tvLanguage;
    TextView tvRelease;
    TextView tvTxtTitle;
    TextView tvTxtRelease;
    TextView tvTxtLanguage;
    TextView tvTxtOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.tv_title);
        imgPoster = findViewById(R.id.iv_poster);
        tvLanguage = findViewById(R.id.tv_language);
        tvRelease = findViewById(R.id.tv_release);
        tvOverview = findViewById(R.id.tv_overview);
        tvTxtLanguage = findViewById(R.id.tv_txt_language);
        tvTxtRelease = findViewById(R.id.tv_txt_release);
        tvTxtOverview = findViewById(R.id.tv_txt_overview);
        tvTxtTitle = findViewById(R.id.tv_txt_title);

        Movie movie = getIntent().getParcelableExtra(EXTRA_PERSON);
        String title = movie.getTitle();

        String bahasa = movie.getLanguage();
        String tahun = movie.getRelease();
        String overview = movie.getOverview();
        int poster = movie.getPoster();

        tvTxtOverview.setText(R.string.txt_overview);
        tvTxtLanguage.setText(R.string.txt_language);
        tvTxtRelease.setText(R.string.txt_release_date);
        tvTxtTitle.setText(R.string.txt_title);
        tvTitle.setText(title);
        tvLanguage.setText(bahasa);
        tvRelease.setText(tahun);
        imgPoster.setImageResource(poster);
        tvOverview.setText(overview);
    }
}

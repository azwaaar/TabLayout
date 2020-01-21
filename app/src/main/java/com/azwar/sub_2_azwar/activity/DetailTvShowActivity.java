package com.azwar.sub_2_azwar.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.azwar.sub_2_azwar.R;
import com.azwar.sub_2_azwar.model.TvShow;

public class DetailTvShowActivity extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";
    ImageView imgPoster;
    TextView tvTitle;
    TextView tvOverview;
    TextView tvCreator;
    TextView tvStatus;
    TextView tvTxtTitle;
    TextView tvTxtCreator;
    TextView tvTxtStatus;
    TextView tvTxtOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        tvTitle = findViewById(R.id.tv_title);
        imgPoster = findViewById(R.id.iv_poster);
        tvCreator = findViewById(R.id.tv_creator);
        tvStatus = findViewById(R.id.tv_status);
        tvOverview = findViewById(R.id.tv_overview);
        tvTxtCreator = findViewById(R.id.tv_txt_creator);
        tvTxtStatus = findViewById(R.id.tv_txt_status);
        tvTxtOverview = findViewById(R.id.tv_txt_overview);
        tvTxtTitle = findViewById(R.id.tv_txt_title);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_PERSON);
        String title = tvShow.getTitle();

        String creatorString = tvShow.getCreator();
        String statusString = tvShow.getStatus();
        String overview = tvShow.getOverview();
        int poster = tvShow.getPoster();

        tvTxtOverview.setText(R.string.txt_overview);
        tvTxtStatus.setText(R.string.txt_status);
        tvTxtCreator.setText(R.string.txt_creator);
        tvTxtTitle.setText(R.string.txt_title);
        tvTitle.setText(title);
        tvCreator.setText(creatorString);
        tvStatus.setText(statusString);
        imgPoster.setImageResource(poster);
        tvOverview.setText(overview);
    }
}

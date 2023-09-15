/**
 * @author rgiaquinto
 * */
package com.example.myapplication.display.recyclerview;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

/**
 * Classe RoverItemViewActivity
 *
 * Activité permettant de voir les détails d'un rover en particulier
 * */
public class RoverItemViewActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView roverName;
    private TextView cameraLongName;
    private TextView cameraShortName;
    private TextView photoId;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rover_item_view_layout);

        imageView = findViewById(R.id.imageRoverView);
        roverName = findViewById(R.id.roverRoverView);
        cameraLongName = findViewById(R.id.cameraLongNameRoverView);
        cameraShortName = findViewById(R.id.cameraShortNameRoverView);
        photoId = findViewById(R.id.photoIdRoverView);
        date = findViewById(R.id.dateRoverView);

        roverName.setText("Rover: "+getIntent().getExtras().getString("roverName"));
        cameraLongName.setText("Camera name: "+getIntent().getExtras().getString("cameraLongName"));
        cameraShortName.setText("Camera short name: "+getIntent().getExtras().getString("cameraShortName"));
        photoId.setText("Photo id: "+getIntent().getExtras().getString("photoId"));
        date.setText("Date: "+getIntent().getExtras().getString("date"));

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).override(250,250);

        Glide.with(this).load(Uri.parse(getIntent().getExtras().getString("imageUrl"))).apply(options).centerCrop().into(this.imageView);

    }

}

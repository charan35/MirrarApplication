/**
 * @author rgiaquinto
 * */
package com.example.myapplication.display.recyclerview;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.entity.RoverPicture;

/**
 * Classe RoverViewHolder
 *
 * Représente un item à afficher dans le recycler view de la recherche
 * */
public class RoverViewHolder extends RecyclerView.ViewHolder {

    private TextView imageId;
    private TextView cameraName;
    private ImageView cameraImage;
    private TextView date;

    private View view;
    private RoverPicture roverPicture;

    public RoverViewHolder(@NonNull View itemView) {

        super(itemView);

        this.view = itemView;

        this.imageId = (TextView) itemView.findViewById(R.id.imgId);
        this.cameraName = (TextView) itemView.findViewById(R.id.cameraName);
        this.cameraImage = (ImageView) itemView.findViewById(R.id.cameraImage);
        this.date = (TextView) itemView.findViewById(R.id.date);
    }
    /**
     * Met a jour la vue avec les nouvelles données
     * @param roverPicture l'objet contenant les infos à afficher
     * */
    public void updateView(RoverPicture roverPicture){

        this.roverPicture = roverPicture;

        this.imageId.setText("N°: "+String.valueOf(roverPicture.getId()));
        this.cameraName.setText("Camera: "+roverPicture.getCamera().getName());
        this.date.setText("Date: "+roverPicture.getDate());

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).override(250,250);

        Glide.with(this.view).load(Uri.parse(roverPicture.getImage())).apply(options).centerCrop().circleCrop().into(this.cameraImage);

    }

    public View getItemView(){
        return this.itemView;
    }

    public RoverPicture getRoverPicture(){
        return this.roverPicture;
    }

}

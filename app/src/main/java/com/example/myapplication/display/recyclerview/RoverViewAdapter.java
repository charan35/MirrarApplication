/**
 * @author rgiaquinto
 * */

package com.example.myapplication.display.recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.entity.RoverPicture;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe RoverViewAdapter
 *
 * Met en place dans la recycler view les différents items RoverViewHolder
 * */
public class RoverViewAdapter extends RecyclerView.Adapter<RoverViewHolder> {

    private List<RoverPicture> roverPictures;

    public RoverViewAdapter(){

        this.roverPictures = new ArrayList<>();
    }

    @NonNull
    @Override
    public RoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View roverItemView = inflater.inflate(R.layout.rover_item, parent, false);

        return new RoverViewHolder(roverItemView);
    }

    public void updateDataSet(List<RoverPicture> roverPictureList){

        this.roverPictures.clear();
        this.roverPictures.addAll(roverPictureList);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final @NonNull RoverViewHolder holder, int position) {

        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RoverItemViewActivity.class);
                intent.putExtra("roverName", holder.getRoverPicture().getRover().getName());
                intent.putExtra("cameraLongName", holder.getRoverPicture().getCamera().getFullName());
                intent.putExtra("cameraShortName", holder.getRoverPicture().getCamera().getName());
                intent.putExtra("date", holder.getRoverPicture().getDate());
                intent.putExtra("photoId", String.valueOf(holder.getRoverPicture().getId()));
                intent.putExtra("imageUrl", holder.getRoverPicture().getImage());

                v.getContext().startActivity(intent);
            }
        });
        holder.updateView(this.roverPictures.get(position));
        setAnimation(holder.getItemView());
    }

    @Override
    public int getItemCount() {

        return this.roverPictures.size();
    }

    private void setAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }
}

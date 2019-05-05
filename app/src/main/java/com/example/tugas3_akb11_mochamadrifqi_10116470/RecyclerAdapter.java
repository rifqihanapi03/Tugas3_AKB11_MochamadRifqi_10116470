package com.example.tugas3_akb11_mochamadrifqi_10116470;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private int[] images;

    public RecyclerAdapter(int[] images)
    {
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout, viewGroup, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {

        int image_id = images[i];
        viewHolder.Album.setImageResource(image_id);
        viewHolder.AlbumTitle.setText("image :" + i);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView Album;
        TextView AlbumTitle;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
        }
    }
}

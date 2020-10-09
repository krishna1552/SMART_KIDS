package com.example.myquiz;


import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myquiz.Interface.ImageOnClick;
import com.example.myquiz.common.Common;

import java.util.ArrayList;
import java.util.List;

public class imageadapter extends RecyclerView.Adapter<ImageViewHolder> {

    private Context mContext;
    private List<Integer> listImages;

    public imageadapter(Context mContext) {
        this.mContext = mContext;
        this.listImages = getImages();
    }

    private List<Integer> getImages(){
        List<Integer> results  = new ArrayList<>();
        results.add(R.drawable.image_01);
        results.add(R.drawable.image_02);
        results.add(R.drawable.image_03);
        results.add(R.drawable.image_04);
        results.add(R.drawable.image_05);
        results.add(R.drawable.image_06);
        results.add(R.drawable.image_07);
        results.add(R.drawable.image_08);
        results.add(R.drawable.image_09);
        results.add(R.drawable.image_10);
        results.add(R.drawable.image_11);
        results.add(R.drawable.image_12);
        results.add(R.drawable.image_13);
        results.add(R.drawable.image_14);
        results.add(R.drawable.image_15);
        results.add(R.drawable.image_16);
        results.add(R.drawable.image_17);
        results.add(R.drawable.image_18);
        results.add(R.drawable.image_19);
        results.add(R.drawable.image_20);
        results.add(R.drawable.image_21);
        results.add(R.drawable.image_22);
        results.add(R.drawable.image_23);
        results.add(R.drawable.image_24);

        return results;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from((Context) mContext).inflate(R.layout.item_images,parent,false);
        return new ImageViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(listImages.get(position));

        holder.setImageOnClick ( new ImageOnClick () {
            @Override
            public void onClick(int pos) {
                Common.PICTURE_SELECTED = listImages.get ( pos );
                mContext.startActivity ( new Intent (mContext,PaintActivity.class));
            }
        } );
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }
}

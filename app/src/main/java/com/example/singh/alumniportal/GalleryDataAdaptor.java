package com.example.singh.alumniportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singh.alumniportal.Model.Gallery;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryDataAdaptor extends RecyclerView.Adapter<GalleryDataAdaptor.ViewHolder> {
private ArrayList<Gallery> list;
private Context context;

public GalleryDataAdaptor(Context context, ArrayList<Gallery> list) {
        this.list = list;
        this.context = context;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(list!=null && list.size()!=0){
//        holder.photo.setImageURI(list.get(position).getEventImage());  ja jee le apni jindagi suno url kaha lagana hai
            Picasso.with(context).load(list.get(position).getEventImage()).into(holder.photo);
        }


        }

@Override
public int getItemCount() {
        return list.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView photo;
    CardView cardView ;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        photo=itemView.findViewById(R.id.alumni_gallery_image);
        cardView=itemView.findViewById(R.id.card_view);
    }
}
}
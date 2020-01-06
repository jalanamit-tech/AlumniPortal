package com.example.singh.alumniportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.singh.alumniportal.Model.Birthday;

import java.util.List;

public class BirthdayAdaptor extends RecyclerView.Adapter<BirthdayAdaptor.BirthdayViewHolder> {

private Context mCtx;
private List<Birthday> birthdayList;


public BirthdayAdaptor(Context mCtx, List<Birthday> birthdayList) {
        this.mCtx = mCtx;
        this.birthdayList = birthdayList;
        }

@Override
public BirthdayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_birthday, null);
        return new BirthdayViewHolder(view);
        }

@Override
public void onBindViewHolder(BirthdayViewHolder holder, int position) {
        //getting the product of the specified position
        Birthday birthday = birthdayList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(birthday.getName());
        holder.textViewBatch.setText(birthday.getBatch());
        holder.textViewBranches.setText(birthday.getBranches());
        holder.textViewDate.setText(birthday.getDate());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(birthday.getImage()));

        }


@Override
public int getItemCount() {
        return birthdayList.size();
        }


class BirthdayViewHolder extends RecyclerView.ViewHolder {

    TextView textViewName, textViewBatch, textViewBranches, textViewDate;
    ImageView imageView;

    public BirthdayViewHolder(View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.birthday_person_name);
        textViewBatch = itemView.findViewById(R.id.birthday_person_batch);
        textViewBranches = itemView.findViewById(R.id.birthday_person_branches);
        textViewDate = itemView.findViewById(R.id.birthday_person_date);
        imageView = itemView.findViewById(R.id.birthday_person_image);
    }
}
}
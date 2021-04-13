package com.lemur.profrate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ratingAdapter extends RecyclerView.Adapter<ratingAdapter.RatingsViewHolder>  {

    private OnItemClickListener onItemClickListener;
    private ArrayList<Ratings> list;

    public ratingAdapter(ArrayList<Ratings> list, OnItemClickListener onItemClickListener) {

        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public RatingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new RatingsViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingsViewHolder holder, int position) {

        holder.teacherNamePrev.setText(list.get(position).getProfFirst() + " " + list.get(position).getProfLast());
        holder.classNamePrev.setText(list.get(position).getClassName());
        holder.classNumPrev.setText((list.get(position).getClassPrefix()
                + " " + list.get(position).getClassNum()));
        holder.rate.setText(String.valueOf(list.get(position).getRating()));
    }

    public int getItemCount(){
        return list.size();
    }

    public class RatingsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        //preview that you click to see full rating
        TextView teacherNamePrev;
        TextView classNamePrev;
        TextView classNumPrev;
        TextView rate;

        OnItemClickListener onItemClickListener;

        public RatingsViewHolder(View itemView, OnItemClickListener onItemClickListener)
        {
            super(itemView);
            teacherNamePrev = itemView.findViewById(R.id.teacherName);
            classNamePrev = itemView.findViewById(R.id.classNamePrev);
            classNumPrev = itemView.findViewById(R.id.classNumPrev);
            rate = itemView.findViewById(R.id.rating);
            this.onItemClickListener = onItemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener
    {
        void onItemClick (int position);
    }


}

package com.applications.werainkhatri.phonebook.listClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.applications.werainkhatri.phonebook.Contact;
import com.applications.werainkhatri.phonebook.Data;
import com.applications.werainkhatri.phonebook.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    Context context;
    List<Contact> dataList;
    LayoutInflater inflater;

    public RvAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.cardview, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder , int i) {
        holder.name.setText(dataList.get(i).getName());
        holder.number.setText(Long.toString(dataList.get(i).getNumber()));
//        Glide.with(context).load(dataList.get(i).getImage()).apply(RequestOptions.circleCropTransform()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, number;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            img = itemView.findViewById(R.id.img);
        }
    }

    public void setDataList(List<Contact> dataList) {
        this.dataList = dataList;
    }
}

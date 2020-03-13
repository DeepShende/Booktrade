package com.example.booktrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{
    private ArrayList<Person> People;
    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list)
    {
        People = list;
        activity =(ItemClicked) context;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView IV1;
        TextView Book_name,Seller_name,Price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV1=itemView.findViewById(R.id.IV1);
            Book_name=itemView.findViewById(R.id.Book_name);
            Seller_name=itemView.findViewById(R.id.Seller_Name);
            Price=itemView.findViewById(R.id.Price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(People.indexOf((Person) view.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int i) {
        holder.itemView.setTag(People.get(i));
        holder.Book_name.setText(People.get(i).getBook_name());
        holder.Seller_name.setText(People.get(i).getSeller_name());
        holder.Price.setText("₹"+People.get(i).getPrice());


        if(People.get(i).getPref().equals("book"))
        {
            holder.IV1.setImageResource(R.drawable.book);
        }
        else
        {
            holder.IV1.setImageResource(R.drawable.computer);
        }
    }

    @Override
    public int getItemCount() {
        return People.size();
    }
}

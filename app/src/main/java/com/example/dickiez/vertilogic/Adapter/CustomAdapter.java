package com.example.dickiez.vertilogic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dickiez.vertilogic.DetailActivity;
import com.example.dickiez.vertilogic.Model.User;
import com.example.dickiez.vertilogic.R;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by Dickiez on 4/10/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {
    List<User> userList;
    Context context;

    public CustomAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_user, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        holder.txtName.setText(userList.get(position).getName());
        holder.txtUsername.setText(userList.get(position).getUsername());
        holder.txtEmail.setText(userList.get(position).getEmail());
        holder.txtPhone.setText(userList.get(position).getPhone());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User data = userList.get(position);
                Intent i = new Intent(holder.itemView.getContext(), DetailActivity. class);
                i.putExtra("user", new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtUsername;
        TextView txtEmail;
        TextView txtPhone;
        public MyHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtUsername = itemView.findViewById(R.id.txt_username);
            txtEmail = itemView.findViewById(R.id.txt_email);
            txtPhone = itemView.findViewById(R.id.txt_phone);
        }
    }
}

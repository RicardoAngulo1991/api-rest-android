package com.example.ricardoangulo.api_rest_android;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * Created by RicardoAngulo on 01/08/2017.
 */

public class ApiRestAdapterRecyclerView extends RecyclerView.Adapter<ApiRestViewHolder>  {
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<ApiRestUsers> crudArrayList;
    private int resources = 0;
    private final int VIEW_TYPE_LOADING = 0;
    public ProgressBar mProgressBar;
    public ApiRestAdapterRecyclerView(ArrayList<ApiRestUsers> data, int resources) {
        this.crudArrayList = data;
        this.resources = resources;
    }

    @Override
    public ApiRestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(this.resources, parent, false);
            return new ApiRestViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(this.resources, parent, false);
            return new ApiRestViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(ApiRestViewHolder holder, int position) {
        holder.setNameTextView(crudArrayList.get(position).getName());
        holder.setAgeTextView(crudArrayList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return this.crudArrayList.size();
    }

    public void clearItems() {
        this.crudArrayList.clear();
        notifyDataSetChanged();
    }
}

package com.example.ricardoangulo.api_rest_android;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by RicardoAngulo on 01/08/2017.
 */

public class ApiRestViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView ageTextView;

    public ApiRestViewHolder(View itemView) {
        super(itemView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        this.ageTextView = (TextView) itemView.findViewById(R.id.ageTextView);
    }


    public TextView getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(String nameTextView) {
        this.nameTextView.setText(nameTextView);
    }

    public TextView getAgeTextView() {
        return ageTextView;
    }

    public void setAgeTextView(String ageTextView) {
        this.ageTextView.setText(ageTextView);
    }
}

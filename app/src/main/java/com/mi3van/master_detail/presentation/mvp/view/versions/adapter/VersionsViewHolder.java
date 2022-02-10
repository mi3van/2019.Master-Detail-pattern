package com.mi3van.master_detail.presentation.mvp.view.versions.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.mi3van.master_detail.R;

class VersionsViewHolder extends RecyclerView.ViewHolder {
    final TextView versionTextView;
    final TextView descriptionTextView;
    final ToggleButton favoriteBtn;
    final LinearLayout backgrLayout;

    VersionsViewHolder(View view) {
        super(view);
        versionTextView = view.findViewById(R.id.version);
        descriptionTextView = view.findViewById(R.id.description);
        favoriteBtn = view.findViewById(R.id.favoriteBtn);
        backgrLayout = view.findViewById(R.id.item_background_layout);
    }
}
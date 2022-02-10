package com.mi3van.master_detail.presentation.mvp.view.versions.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mi3van.master_detail.R;
import com.mi3van.master_detail.domain.entitie.VersionModel;

import java.util.ArrayList;
import java.util.List;

public class VersionsRecyclerAdapter extends RecyclerView.Adapter<VersionsViewHolder> {

    private final List<VersionModel> _versions = new ArrayList<>();
    private VersionsRecyclerListener _delegate;
    private int _rowIndex = -1;

    public VersionsRecyclerAdapter(VersionsRecyclerListener delegate) {
        _delegate = delegate;
    }

    @Override
    public VersionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new VersionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final VersionsViewHolder holder, int position) {
        VersionModel currentModel = _versions.get(position);
        holder.versionTextView.setText(String.valueOf(currentModel.getVersion()));
        holder.descriptionTextView.setText(currentModel.getName());

        holder.itemView.setOnClickListener(view -> {
            if (_delegate != null) {
                _delegate.onElementClick(currentModel, position);
            }
        });

        if (position == _rowIndex) {
            holder.backgrLayout.setBackgroundResource(R.color.colorPrimary);
        } else {
            holder.backgrLayout.setBackgroundColor(Color.TRANSPARENT);
        }

        holder.itemView.setOnLongClickListener(v -> {
            _delegate.onElementLongClick(currentModel);
            return true;
        });

        holder.favoriteBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (_delegate != null) {
                _delegate.onFavouriteClick(currentModel.getId(), isChecked);
            }
        });
    }

    public void selectEffectForAdapter(int position) {
        _rowIndex = position;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
            return _versions.size();
        }

    public void setData(List<VersionModel> versionModels) {
        _versions.clear();
        _versions.addAll(versionModels);
    }
}
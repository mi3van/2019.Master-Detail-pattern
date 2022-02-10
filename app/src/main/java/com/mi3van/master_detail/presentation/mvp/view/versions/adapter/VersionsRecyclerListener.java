package com.mi3van.master_detail.presentation.mvp.view.versions.adapter;

import com.mi3van.master_detail.domain.entitie.VersionModel;

/**
 * Created by Ivan Kuzmin on 02.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface VersionsRecyclerListener {
    void onElementClick(VersionModel model, int position);
    void onElementLongClick(VersionModel model);
    void onFavouriteClick(int modelId, Boolean isFavorite);
}

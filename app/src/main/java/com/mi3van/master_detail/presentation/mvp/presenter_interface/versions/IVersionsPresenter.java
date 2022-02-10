package com.mi3van.master_detail.presentation.mvp.presenter_interface.versions;

import com.mi3van.master_detail.domain.entitie.VersionModel;

/**
 * Created by Ivan Kuzmin on 04.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface IVersionsPresenter {

    void favoriteBtnWasClicked(int modelId, Boolean isFavorite);

    void versionWasLongClick(VersionModel versionModel);

    void showDetailVersion(VersionModel versionModel, int position);
}

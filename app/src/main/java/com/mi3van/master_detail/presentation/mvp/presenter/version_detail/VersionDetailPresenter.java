package com.mi3van.master_detail.presentation.mvp.presenter.version_detail;

import com.arellomobile.mvp.InjectViewState;
import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.presentation.dagger.application.ApplicationComponent;
import com.mi3van.master_detail.presentation.mvp.presenter.base.BaseMvpPresenter;
import com.mi3van.master_detail.presentation.mvp.presenter_interface.version_detail.IVersionDetailPresenter;
import com.mi3van.master_detail.presentation.mvp.view_interface.version_detail.VersionDetailView;

/**
 * Created by Ivan Kuzmin on 02.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

@InjectViewState
public class VersionDetailPresenter extends BaseMvpPresenter<VersionDetailView>
        implements IVersionDetailPresenter {

    @Override
    protected void inject(ApplicationComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public void setVersionModel(VersionModel versionModel) {
        if (versionModel != null) {
            getViewState().updateView(versionModel);
        }
    }
}

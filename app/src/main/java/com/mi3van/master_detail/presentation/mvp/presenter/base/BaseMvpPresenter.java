package com.mi3van.master_detail.presentation.mvp.presenter.base;

import com.arellomobile.mvp.MvpPresenter;
import com.mi3van.master_detail.presentation.AndroidApplication;
import com.mi3van.master_detail.presentation.dagger.application.ApplicationComponent;
import com.mi3van.master_detail.presentation.mvp.view_interface.BaseMvpView;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public abstract class BaseMvpPresenter<VIEW extends BaseMvpView> extends MvpPresenter<VIEW> {

    public BaseMvpPresenter() {
        super();
        inject(getAppComponent());
    }

    private ApplicationComponent getAppComponent() {
        return AndroidApplication.getAppComponent();
    }

    protected abstract void inject(ApplicationComponent appComponent);
}

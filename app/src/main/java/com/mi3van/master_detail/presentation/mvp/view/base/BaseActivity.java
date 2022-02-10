package com.mi3van.master_detail.presentation.mvp.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.mi3van.master_detail.presentation.AndroidApplication;
import com.mi3van.master_detail.presentation.dagger.ComponentFactory;
import com.mi3van.master_detail.presentation.dagger.activity.ActivityComponent;
import com.mi3van.master_detail.presentation.dagger.application.ApplicationComponent;
import com.mi3van.master_detail.presentation.mvp.view_interface.BaseMvpView;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public abstract class BaseActivity extends MvpAppCompatActivity implements BaseMvpView {

    private ActivityComponent _activityComponent;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getActivityComponent());
    }

    public ActivityComponent getActivityComponent() {
        if (_activityComponent == null) {
            _activityComponent = ComponentFactory.createActivityComponent(this, getAppComponent());
        }
        return _activityComponent;
    }

    @Override
    public void showErrorMessage(Throwable throwable) {
        Toast.makeText(getApplicationContext(), throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingIndicator() {
        Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoadingIndicator() {
        Toast.makeText(getApplicationContext(), "Loading finished!", Toast.LENGTH_SHORT).show();    }

    protected abstract void inject(final ActivityComponent activityComponent);

    private ApplicationComponent getAppComponent() {
        return AndroidApplication.getAppComponent();
    }

}

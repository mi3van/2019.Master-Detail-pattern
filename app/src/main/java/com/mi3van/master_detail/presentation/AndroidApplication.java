package com.mi3van.master_detail.presentation;

import android.app.Application;

import com.mi3van.master_detail.presentation.dagger.ComponentFactory;
import com.mi3van.master_detail.presentation.dagger.application.ApplicationComponent;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class AndroidApplication extends Application {

    private static ApplicationComponent _appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    public static ApplicationComponent getAppComponent() {
        return _appComponent;
    }

    private void initializeInjector() {
        _appComponent = ComponentFactory.createApplicationComponent(this);
        _appComponent.inject(this);
    }
}

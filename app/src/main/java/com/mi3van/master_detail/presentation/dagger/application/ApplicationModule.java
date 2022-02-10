package com.mi3van.master_detail.presentation.dagger.application;

import android.content.Context;
import android.content.res.Resources;

import com.mi3van.master_detail.presentation.AndroidApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

@Module
public class ApplicationModule {
    private final AndroidApplication _app;

    public ApplicationModule(AndroidApplication application) {
        this._app = application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideAppContext() {
        return _app;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return _app.getResources();
    }

    public interface Exposes {

        @ForApplication
        Context context();

        Resources resources();
    }
}

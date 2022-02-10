package com.mi3van.master_detail.presentation.dagger.application;

import com.mi3van.master_detail.presentation.AndroidApplication;
import com.mi3van.master_detail.presentation.dagger.presenter.PresenterInjectForApp;
import com.mi3van.master_detail.presentation.dagger.modules.DataModule;
import com.mi3van.master_detail.presentation.dagger.modules.UseCaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DataModule.class,
        UseCaseModule.class
})
public interface ApplicationComponent extends AppComponentExposes, PresenterInjectForApp {

    void inject(AndroidApplication androidApplication);

    final class Initializer {

        static public ApplicationComponent init(final AndroidApplication androidApplication) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(androidApplication))
                    .useCaseModule(new UseCaseModule())
                    .dataModule(new DataModule())
                    .build();
        }

        private Initializer() {
        }
    }

}

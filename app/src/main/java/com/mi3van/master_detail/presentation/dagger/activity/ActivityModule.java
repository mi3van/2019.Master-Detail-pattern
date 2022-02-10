package com.mi3van.master_detail.presentation.dagger.activity;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import com.mi3van.master_detail.presentation.mvp.view.base.BaseActivity;
import com.mi3van.master_detail.presentation.router.Router;
import com.mi3van.master_detail.presentation.router.RouterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan Kuzmin on 04.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

@Module
public class ActivityModule {
    private final BaseActivity _activity;

    public ActivityModule(BaseActivity activity) {
        this._activity = activity;
    }

//    @Provides
//    @ActivityScope
//    @ForActivity
//    Context provideActivityContext() {
//        return _activity;
//    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return _activity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return _activity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    Router provideRouter(final FragmentManager fragmentManager) {
        return new RouterImpl(_activity, fragmentManager);
    }

    public interface Exposes {

        Activity activity();

//        @ForActivity
//        Context context();

        FragmentManager fragmentManager();

        Router router();
    }
}

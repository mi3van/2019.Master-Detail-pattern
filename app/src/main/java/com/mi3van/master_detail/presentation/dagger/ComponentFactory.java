package com.mi3van.master_detail.presentation.dagger;

import com.mi3van.master_detail.presentation.AndroidApplication;
import com.mi3van.master_detail.presentation.dagger.activity.ActivityComponent;
import com.mi3van.master_detail.presentation.dagger.application.ApplicationComponent;
import com.mi3van.master_detail.presentation.mvp.view.base.BaseActivity;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(
            final AndroidApplication androidApplication) {
        return ApplicationComponent.Initializer.init(androidApplication);
    }

    public static ActivityComponent createActivityComponent(
            final BaseActivity baseActivity,
            final ApplicationComponent appComponent) {
        return ActivityComponent.Initializer.init(baseActivity, appComponent);
    }

}
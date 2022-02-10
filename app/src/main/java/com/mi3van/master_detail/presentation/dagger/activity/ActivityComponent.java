package com.mi3van.master_detail.presentation.dagger.activity;

import com.mi3van.master_detail.presentation.dagger.application.ApplicationComponent;
import com.mi3van.master_detail.presentation.mvp.view.base.BaseActivity;
import com.mi3van.master_detail.presentation.mvp.view.versions.VersionsActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class
        }
)
public interface ActivityComponent extends ActivityComponentExposes {

    void inject(VersionsActivity versionsActivity);

    final class Initializer {

        static public ActivityComponent init(final BaseActivity baseActivity, final ApplicationComponent applicationComponent) {
            return DaggerActivityComponent.builder()
                                          .applicationComponent(applicationComponent)
                                          .activityModule(new ActivityModule(baseActivity))
                                          .build();
        }

        private Initializer() {
        }
    }
}

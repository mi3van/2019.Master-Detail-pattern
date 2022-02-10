package com.mi3van.master_detail.presentation.dagger.presenter;

import com.mi3van.master_detail.presentation.mvp.presenter.version_detail.VersionDetailPresenter;
import com.mi3van.master_detail.presentation.mvp.presenter.versions.VersionsPresenter;

/**
 * Created by Ivan Kuzmin on 04.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface PresenterInjectForApp {

    void inject(VersionsPresenter versionsPresenter);

    void inject(VersionDetailPresenter versionsPresenter);
}

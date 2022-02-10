package com.mi3van.master_detail.presentation.mvp.view_interface.version_detail;

import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.presentation.mvp.view_interface.BaseMvpView;

/**
 * Created by Ivan Kuzmin on 02.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface VersionDetailView extends BaseMvpView {

    void updateView(VersionModel versionModel);
}

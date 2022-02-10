package com.mi3van.master_detail.presentation.mvp.view_interface.versions;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.presentation.mvp.view_interface.BaseMvpView;

import java.util.List;

/**
 * Created by Ivan Kuzmin on 02.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface VersionsView extends BaseMvpView {
    void showVersions(List<VersionModel> versionModels);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showVersionDetail(VersionModel versionModel);

    void selectEffectForAdapter(int position);

    void showAlertDialogForDelete(VersionModel versionModel);
}

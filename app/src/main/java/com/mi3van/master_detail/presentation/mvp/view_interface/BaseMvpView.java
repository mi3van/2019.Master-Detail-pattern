package com.mi3van.master_detail.presentation.mvp.view_interface;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface BaseMvpView extends MvpView {

    void showErrorMessage(Throwable throwable);

    void showLoadingIndicator();

    void hideLoadingIndicator();
}

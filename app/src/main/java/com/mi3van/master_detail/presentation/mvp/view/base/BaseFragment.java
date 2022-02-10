package com.mi3van.master_detail.presentation.mvp.view.base;

import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.mi3van.master_detail.presentation.mvp.view_interface.BaseMvpView;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseMvpView {

    @Override
    public void showErrorMessage(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingIndicator() {
        Toast.makeText(getContext(), "Loading...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoadingIndicator() {
        Toast.makeText(getContext(), "Loading finished!", Toast.LENGTH_SHORT).show();    }

}

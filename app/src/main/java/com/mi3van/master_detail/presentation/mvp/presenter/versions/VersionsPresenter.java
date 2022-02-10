package com.mi3van.master_detail.presentation.mvp.presenter.versions;

import com.arellomobile.mvp.InjectViewState;
import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.domain.interactor.versions.DeleteVersionUseCase;
import com.mi3van.master_detail.domain.interactor.versions.GetVersionsUseCase;
import com.mi3van.master_detail.domain.interactor.versions.SetFavoriteVersionUseCase;
import com.mi3van.master_detail.presentation.dagger.application.ApplicationComponent;
import com.mi3van.master_detail.presentation.mvp.presenter.base.BaseMvpPresenter;
import com.mi3van.master_detail.presentation.mvp.presenter_interface.versions.IVersionsPresenter;
import com.mi3van.master_detail.presentation.mvp.view_interface.versions.VersionsView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ivan Kuzmin on 02.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

@InjectViewState
public class VersionsPresenter extends BaseMvpPresenter<VersionsView>
        implements IVersionsPresenter {

    @Override
    protected void inject(ApplicationComponent appComponent) {
        appComponent.inject(this);
    }

    @Inject
    GetVersionsUseCase _versionsUseCase;

    @Inject
    SetFavoriteVersionUseCase _favoriteVersionUseCase;

    @Inject
    DeleteVersionUseCase _deleteVersionUseCase;

    private CompositeDisposable _disposables = new CompositeDisposable();

    public VersionsPresenter() {
        super();
        getVersions();
    }

    public void favoriteBtnWasClicked(int modelId, Boolean isFavorite) {
        _favoriteVersionUseCase.execute(modelId, isFavorite);
    }

    public void versionWasLongClick(VersionModel versionModel) {
        getViewState().showAlertDialogForDelete(versionModel);
//        _deleteVersionUseCase
    }

    @Override
    public void showDetailVersion(VersionModel versionModel, int position) {
        getViewState().showVersionDetail(versionModel);
        getViewState().selectEffectForAdapter(position);
    }

    private void getVersions() {
        _disposables.add(_versionsUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(this::onSuccess)
                .doOnError(this::onError)
                .subscribe());
    }

    private void onSuccess(final List<VersionModel> versionModels) {
        getViewState().showVersions(versionModels);
    }

    private void onError(final Throwable throwable) {
        getViewState().showErrorMessage(throwable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        _disposables.dispose();
    }
}

package com.mi3van.master_detail.data.versions;

import com.mi3van.master_detail.data.DbAccess;
import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.domain.repository.VersionsRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class VersionsRepositoryImpl implements VersionsRepository {

    private DbAccess dbAccess;

    public VersionsRepositoryImpl(DbAccess dbAccess) {
        this.dbAccess = dbAccess;
    }

    @Override
    public Single<List<VersionModel>> versions() {
        return new Single<List<VersionModel>>() {
            @Override
            protected void subscribeActual(SingleObserver<? super List<VersionModel>> observer) {
                observer.onSuccess(dbAccess.getVersionsList());
            }
        };
    }

    @Override
    public Completable updateIsFavoriteModel(int modelId, Boolean isFavorite) {
        return null;
    }

    @Override
    public Completable deleteModel(VersionModel model) {
        return null;
    }
}

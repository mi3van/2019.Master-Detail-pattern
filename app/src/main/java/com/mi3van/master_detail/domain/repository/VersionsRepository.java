package com.mi3van.master_detail.domain.repository;

import com.mi3van.master_detail.domain.entitie.VersionModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Ivan Kuzmin on 02.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface VersionsRepository {
    Single<List<VersionModel>> versions();

    Completable updateIsFavoriteModel(int modelId, Boolean isFavorite);

    Completable deleteModel(VersionModel model);
}

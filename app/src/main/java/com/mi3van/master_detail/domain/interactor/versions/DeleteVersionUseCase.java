package com.mi3van.master_detail.domain.interactor.versions;

import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.domain.interactor.type.CompletableUseCaseWithParameter;
import com.mi3van.master_detail.domain.repository.VersionsRepository;

import io.reactivex.Completable;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class DeleteVersionUseCase implements CompletableUseCaseWithParameter<VersionModel> {

    private final VersionsRepository _versionsRepository;

    public DeleteVersionUseCase(final VersionsRepository _versionsRepository) {
        this._versionsRepository = _versionsRepository;
    }

    @Override
    public Completable execute(VersionModel parameter) {
        return _versionsRepository.deleteModel(parameter);
    }
}

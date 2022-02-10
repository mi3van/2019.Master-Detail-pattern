package com.mi3van.master_detail.domain.interactor.versions;

import com.mi3van.master_detail.domain.interactor.type.CompletableUseCaseWithTwoParameters;
import com.mi3van.master_detail.domain.repository.VersionsRepository;

import io.reactivex.Completable;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class SetFavoriteVersionUseCase implements CompletableUseCaseWithTwoParameters<Integer, Boolean> {

    private final VersionsRepository _versionsRepository;

    public SetFavoriteVersionUseCase(final VersionsRepository _versionsRepository) {
        this._versionsRepository = _versionsRepository;
    }

    @Override
    public Completable execute(Integer parameter, Boolean parameter2) {
        return _versionsRepository.updateIsFavoriteModel(parameter, parameter2);
    }
}

package com.mi3van.master_detail.domain.interactor.versions;

import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.domain.interactor.type.SingleUseCase;
import com.mi3van.master_detail.domain.repository.VersionsRepository;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class GetVersionsUseCase implements SingleUseCase<List<VersionModel>> {

    private final VersionsRepository _versionsRepository;

    public GetVersionsUseCase(final VersionsRepository _versionsRepository) {
        this._versionsRepository = _versionsRepository;
    }

    @Override
    public Single<List<VersionModel>> execute() {
        return _versionsRepository.versions();
    }
}

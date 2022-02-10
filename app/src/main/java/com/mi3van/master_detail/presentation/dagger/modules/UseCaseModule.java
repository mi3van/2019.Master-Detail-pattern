package com.mi3van.master_detail.presentation.dagger.modules;

import com.mi3van.master_detail.domain.interactor.versions.DeleteVersionUseCase;
import com.mi3van.master_detail.domain.interactor.versions.GetVersionsUseCase;
import com.mi3van.master_detail.domain.interactor.versions.SetFavoriteVersionUseCase;
import com.mi3van.master_detail.domain.repository.VersionsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

@Module
public class UseCaseModule {

    @Provides
    @Singleton
    GetVersionsUseCase provideGetVersionsUseCase(final VersionsRepository versionsRepository) {
        return new GetVersionsUseCase(versionsRepository);
    }

    @Provides
    @Singleton
    SetFavoriteVersionUseCase provideSetFavoriteVersionUseCase(final VersionsRepository versionsRepository) {
        return new SetFavoriteVersionUseCase(versionsRepository);
    }

    @Provides
    @Singleton
    DeleteVersionUseCase provideDeleteVersionUseCase(final VersionsRepository versionsRepository) {
        return new DeleteVersionUseCase(versionsRepository);
    }

    public interface Exposes {
        GetVersionsUseCase getVersionsUseCase();

        SetFavoriteVersionUseCase getSetFavoriteVersionUseCase();

        DeleteVersionUseCase getDeleteVersionUseCase();
    }
}

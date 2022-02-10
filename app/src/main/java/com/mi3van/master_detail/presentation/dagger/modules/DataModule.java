package com.mi3van.master_detail.presentation.dagger.modules;

import android.content.Context;

import com.mi3van.master_detail.data.DbAccess;
import com.mi3van.master_detail.data.DbOpenHelper;
import com.mi3van.master_detail.data.versions.VersionsRepositoryImpl;
import com.mi3van.master_detail.domain.repository.VersionsRepository;
import com.mi3van.master_detail.presentation.dagger.application.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    VersionsRepository getVersionsRepository(DbAccess dbAccess) {
        return new VersionsRepositoryImpl(dbAccess);
    }

    @Provides
    @Singleton
    DbAccess getDbAccess(DbOpenHelper openHelper) {
        return new DbAccess(openHelper);
    }

    @Provides
    @Singleton
    DbOpenHelper getDbOpenHelper(@ForApplication Context context) {
        return new DbOpenHelper(context);
    }

    public interface Exposes {
        VersionsRepository versionsRepository();

        DbAccess dbAccess();

        DbOpenHelper dbOpenHelper();
    }
}

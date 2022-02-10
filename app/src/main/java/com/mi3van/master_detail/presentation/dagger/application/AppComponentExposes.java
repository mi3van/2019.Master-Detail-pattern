package com.mi3van.master_detail.presentation.dagger.application;

import com.mi3van.master_detail.presentation.dagger.modules.DataModule;
import com.mi3van.master_detail.presentation.dagger.modules.UseCaseModule;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface AppComponentExposes extends
        ApplicationModule.Exposes,
        DataModule.Exposes,
        UseCaseModule.Exposes {
}

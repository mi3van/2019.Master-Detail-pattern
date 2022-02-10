package com.mi3van.master_detail.domain.interactor.type;

import io.reactivex.Observable;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface UseCaseWithParameter<P, R> {

    Observable<R> execute(P parameter);
}

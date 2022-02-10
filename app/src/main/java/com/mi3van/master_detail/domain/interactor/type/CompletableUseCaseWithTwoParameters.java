package com.mi3van.master_detail.domain.interactor.type;

import io.reactivex.Completable;

/**
 * Created by Ivan Kuzmin on 03.11.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public interface CompletableUseCaseWithTwoParameters<P, P2> {

    Completable execute(P parameter, P2 parameter2);
}

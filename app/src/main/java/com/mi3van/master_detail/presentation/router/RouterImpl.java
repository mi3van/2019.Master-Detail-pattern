package com.mi3van.master_detail.presentation.router;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mi3van.master_detail.R;
import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.presentation.dagger.activity.ActivityScope;
import com.mi3van.master_detail.presentation.mvp.view.version_detail.VersionDetailFragment;

import java.util.concurrent.Callable;

import io.reactivex.functions.Consumer;

@ActivityScope
public final class RouterImpl implements Router {

    private static final int LAST_FRAGMENT = 0;

    private final Activity activity;
    private final FragmentManager fragmentManager;

    public RouterImpl(final Activity activity, final FragmentManager fragmentManager) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void showVersionDetailScreen(VersionModel versionModel) throws Exception {
        advanceToFragment(VersionDetailFragment.TAG,
                () -> {
                    VersionDetailFragment versionDetailFragment = new VersionDetailFragment();
                    versionDetailFragment.setData(versionModel);
                    return versionDetailFragment; },
                versionDetailFragment -> versionDetailFragment.setData(versionModel));
    }

    private <T extends Fragment> void advanceToFragment(final String fragmentTag,
                                                        final Callable<T> destinationFragmentFactory,
                                                        final Consumer<T> destinationFragmentExistsAction) throws Exception {
        T fragment = (T) fragmentManager.findFragmentByTag(fragmentTag);

        if (fragment == null) {
            fragment = destinationFragmentFactory.call();
            fragmentManager.beginTransaction()
//                           .setCustomAnimations(R.anim.fragment_left_enter, R.anim.fragment_right_exit, R.anim.fragment_right_enter, R.anim.fragment_left_exit)
                           .addToBackStack(fragmentTag)
                           .add(R.id.fragment_detail_container, fragment, fragmentTag)
                           .commit();
        } else {
            destinationFragmentExistsAction.accept(fragment);
//            fragmentManager.beginTransaction()
//                           .addToBackStack(null)
//                           .hide(sourceFragment)
//                           .show(fragment)
//                           .commit();
        }
    }
}

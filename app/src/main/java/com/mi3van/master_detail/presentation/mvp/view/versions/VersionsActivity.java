package com.mi3van.master_detail.presentation.mvp.view.versions;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mi3van.master_detail.R;
import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.presentation.dagger.activity.ActivityComponent;
import com.mi3van.master_detail.presentation.mvp.presenter.versions.VersionsPresenter;
import com.mi3van.master_detail.presentation.mvp.view.base.BaseActivity;
import com.mi3van.master_detail.presentation.mvp.view.versions.adapter.VersionsRecyclerAdapter;
import com.mi3van.master_detail.presentation.mvp.view.versions.adapter.VersionsRecyclerListener;
import com.mi3van.master_detail.presentation.mvp.view_interface.versions.VersionsView;
import com.mi3van.master_detail.presentation.router.Router;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

public class VersionsActivity extends BaseActivity implements VersionsView, VersionsRecyclerListener {

    @InjectPresenter
    VersionsPresenter _versionsPresenter;

    @Inject
    Router _router;

    @Inject
    FragmentManager _fragmManager;

    private VersionsRecyclerAdapter _recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versions);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        _recyclerAdapter = new VersionsRecyclerAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(_recyclerAdapter);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void onElementClick(VersionModel model, int position) {
        _versionsPresenter.showDetailVersion(model, position);
    }

    @Override
    public void onElementLongClick(VersionModel model) {
        _versionsPresenter.versionWasLongClick(model);
    }

    @Override
    public void onFavouriteClick(int modelId, Boolean isFavorite) {
        _versionsPresenter.favoriteBtnWasClicked(modelId, isFavorite);
    }

    @Override
    public void showVersions(List<VersionModel> versionModels) {
        _recyclerAdapter.setData(versionModels);
        // todo change notify to DiffUtils
        _recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showVersionDetail(VersionModel versionModel) {
        try {
            _router.showVersionDetailScreen(versionModel);
        } catch (Exception e) {
            showErrorMessage(e);
        }
    }

    @Override
    public void selectEffectForAdapter(int position) {
        _recyclerAdapter.selectEffectForAdapter(position);
    }

    private WeakReference<AlertDialog> _currentDeleteDialog;
    @Override
    public void showAlertDialogForDelete(VersionModel versionModel) {
        if (_currentDeleteDialog != null) {
            _currentDeleteDialog.get().dismiss();
        }
        _currentDeleteDialog = new WeakReference<>(getAlertDialogForDelete(versionModel));
        _currentDeleteDialog.get().show();
    }

    private AlertDialog getAlertDialogForDelete(VersionModel versionModel) {
        return new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.delete_version_title))
                    .setMessage(getString(R.string.delete_version_description) +
                            versionModel.getVersion() + " " +
                            versionModel.getName() + "\"?")
                    .setPositiveButton(getString(R.string.btn_yes), (dialog, which) -> {
//                        _versionsPresenter. todo delete element
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(getString(R.string.btn_no), null)
                    .setIcon(android.R.drawable.ic_dialog_alert).create();
    }
}

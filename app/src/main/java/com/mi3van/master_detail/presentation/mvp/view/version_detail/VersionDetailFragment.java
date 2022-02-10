package com.mi3van.master_detail.presentation.mvp.view.version_detail;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mi3van.master_detail.R;
import com.mi3van.master_detail.domain.entitie.VersionModel;
import com.mi3van.master_detail.presentation.mvp.presenter.version_detail.VersionDetailPresenter;
import com.mi3van.master_detail.presentation.mvp.view.base.BaseFragment;
import com.mi3van.master_detail.presentation.mvp.view_interface.version_detail.VersionDetailView;


public class VersionDetailFragment extends BaseFragment implements VersionDetailView {
    public static final String TAG = "VersionDetailFragment";

    @InjectPresenter(type = PresenterType.LOCAL)
    VersionDetailPresenter _versionDetailPresenter;

    private TextView _itemDetailTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        _itemDetailTextView = rootView.findViewById(R.id.item_detail);

        return rootView;
    }

    private VersionModel _versionModel;
    public void setData(VersionModel versionModel) {
        if (_versionDetailPresenter != null) {
            _versionDetailPresenter.setVersionModel(versionModel);
        } else {
            _versionModel = versionModel;
        }
    }

    @Override
    public void updateView(VersionModel versionModel) {
        Activity activity = this.getActivity();
        Toolbar appBarLayout = null;
        if (activity != null) {
            appBarLayout = activity.findViewById(R.id.toolbar);
        }
        if (appBarLayout != null) {
            appBarLayout.setTitle(versionModel.getName());
        }
        if (_itemDetailTextView != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Version: ");
            stringBuilder.append(versionModel.getVersion());
            stringBuilder.append("\n\nName: ");
            stringBuilder.append(versionModel.getName());
            stringBuilder.append("\n\nReleased: ");
            stringBuilder.append(versionModel.getReleased());
            stringBuilder.append("\n\nAPI: ");
            stringBuilder.append(versionModel.getApi());
            stringBuilder.append("\n\nDistribution: ");
            stringBuilder.append(versionModel.getDistribution());
            stringBuilder.append("\n\n");
            stringBuilder.append(versionModel.getDescription());
            _itemDetailTextView.setText(stringBuilder.toString());
        }
    }

    @ProvidePresenter(type = PresenterType.LOCAL)
    VersionDetailPresenter provideRepositoryPresenter() {
        VersionDetailPresenter versionDetailPresenter = new VersionDetailPresenter();
        versionDetailPresenter.setVersionModel(_versionModel);
        return versionDetailPresenter;
    }
}

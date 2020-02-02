package com.mattech.outgoer.login;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment implements FragmentNavigationContract.MvpView {
    protected FragmentNavigationContract.MvpPresenter navigationPresenter;

    @Override
    public void attachPresenter(FragmentNavigationContract.MvpPresenter mvpPresenter) {
        navigationPresenter = mvpPresenter;
    }
}

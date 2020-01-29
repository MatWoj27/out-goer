package com.mattech.outgoer.main;

import android.view.MenuItem;

public class MainPresenter implements MainContract.MvpPresenter {
    private MainContract.MvpView mvpView;

    public MainPresenter(MainContract.MvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void handleSignOutBtnClick() {

    }

    @Override
    public void handleNavigationItemSelection(MenuItem item) {

    }
}

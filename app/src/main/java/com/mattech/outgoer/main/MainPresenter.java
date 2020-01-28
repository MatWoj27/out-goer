package com.mattech.outgoer.main;

import android.view.MenuItem;

public class MainPresenter implements MainContract.mvpPresenter {
    private MainContract.mvpView mvpView;

    public MainPresenter(MainContract.mvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void handleSignOutBtnClick() {

    }

    @Override
    public void handleNavigationItemSelection(MenuItem item) {

    }
}

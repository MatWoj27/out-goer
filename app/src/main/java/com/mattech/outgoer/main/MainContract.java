package com.mattech.outgoer.main;

import android.view.MenuItem;

public interface MainContract {
    interface MvpView {
        void showLoginScreen();
    }

    interface MvpPresenter {
        void handleSignOutBtnClick();

        void handleNavigationItemSelection(MenuItem item);
    }
}

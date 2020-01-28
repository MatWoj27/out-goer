package com.mattech.outgoer.main;

import android.view.MenuItem;

public interface MainContract {
    interface mvpView {
        void showLoginScreen();
    }

    interface mvpPresenter {
        void handleSignOutBtnClick();

        void handleNavigationItemSelection(MenuItem item);
    }
}

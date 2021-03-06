package com.mattech.outgoer.login.sign_in;

public interface SignInContract {
    interface MvpView {
        void showMainScreen();

        void displayEmptyUsernameWarning();

        void displayEmptyPasswordWarning();
    }

    interface MvpPresenter {
        void handleSignInBtnClick(String username, String password);
    }
}

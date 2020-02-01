package com.mattech.outgoer.login;

public interface SignInContract {
    interface MvpView {
        void showSignUpScreen();

        void showResetPasswordScreen();

        void showMainScreen();

        void displayEmptyUsernameWarning();

        void displayEmptyPasswordWarning();
    }

    interface MvpPresenter {
        void handleSignInBtnClick(String username, String password);

        void handleSignUpBtnClick();

        void handleForgotPasswordBtnClick();
    }
}

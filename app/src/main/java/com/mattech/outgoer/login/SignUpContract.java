package com.mattech.outgoer.login;

public interface SignUpContract {
    interface MvpView {
        void displayEmptyEmailWarning();

        void displayEmptyUsernameWarning();

        void displayEmptyPasswordWarning();

        void displayEmptyRepeatedPasswordWarning();

        void displayPasswordsNotMatchingWarning();

        void showSignInScreen();
    }

    interface MvpPresenter {
        void handleSignUpBtnClick(String mail, String username, String password, String repeatedPassword);

        void handleSignInBtnClick();
    }
}

package com.mattech.outgoer.login.sign_up;

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
    }
}

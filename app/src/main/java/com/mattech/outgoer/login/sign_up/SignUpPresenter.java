package com.mattech.outgoer.login.sign_up;

public class SignUpPresenter implements SignUpContract.MvpPresenter {
    private SignUpContract.MvpView mvpView;

    public SignUpPresenter(SignUpContract.MvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void handleSignUpBtnClick(String mail, String username, String password, String repeatedPassword) {
        if (mail.trim().isEmpty()) {
            mvpView.displayEmptyEmailWarning();
        } else if (username.trim().isEmpty()) {
            mvpView.displayEmptyUsernameWarning();
        } else if (password.trim().isEmpty()) {
            mvpView.displayEmptyPasswordWarning();
        } else if (repeatedPassword.trim().isEmpty()) {
            mvpView.displayEmptyRepeatedPasswordWarning();
        } else if (!password.equals(repeatedPassword)) {
            mvpView.displayPasswordsNotMatchingWarning();
        } else {
            mvpView.showSignInScreen();
        }
    }
}

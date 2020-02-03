package com.mattech.outgoer.login.sign_in;

public class SignInPresenter implements SignInContract.MvpPresenter {
    private SignInContract.MvpView mvpView;

    public SignInPresenter(SignInContract.MvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void handleSignInBtnClick(String username, String password) {
        if (username.trim().isEmpty()) {
            mvpView.displayEmptyUsernameWarning();
        } else if (password.trim().isEmpty()) {
            mvpView.displayEmptyPasswordWarning();
        } else {
            mvpView.showMainScreen();
        }
    }
}

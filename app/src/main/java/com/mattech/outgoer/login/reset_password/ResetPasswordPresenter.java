package com.mattech.outgoer.login.reset_password;

public class ResetPasswordPresenter implements ResetPasswordContract.MvpPresenter {
    private ResetPasswordContract.MvpView mvpView;

    public ResetPasswordPresenter(ResetPasswordContract.MvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void handleSendEmailBtnClick(String email) {
        mvpView.showResetCodeScreen();
    }

    @Override
    public void handleVerifyRestCodeBtnClick(String resetCode) {
        mvpView.showSetNewPasswordScreen();
    }

    @Override
    public void handleConfirmPasswordChangeBtnClick(String password, String repeatedPassword) {

    }
}

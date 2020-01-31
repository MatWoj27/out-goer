package com.mattech.outgoer.login;

public interface ResetPasswordContract {
    interface MvpView {
        void showResetCodeScreen();

        void showSetNewPasswordScreen();
    }

    interface MvpPresenter {
        void handleSendEmailBtnClick(String email);

        void handleVerifyRestCodeBtnClick(String resetCode);

        void handleConfirmPasswordChangeBtnClick(String password, String repeatedPassword);
    }
}

package com.mattech.outgoer.login;

public interface LoginContract {
    interface MvpView {
        void setFragment(BaseFragment fragment, LoginActivity.AnimationType animationType);
    }
}

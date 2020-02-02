package com.mattech.outgoer.login;

public class LoginPresenter implements FragmentNavigationContract.MvpPresenter {
    private LoginContract.MvpView mvpView;

    public LoginPresenter(LoginContract.MvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void addFragment(BaseFragment fragment, LoginActivity.AnimationType animationType) {
        mvpView.setFragment(fragment, animationType);
    }
}

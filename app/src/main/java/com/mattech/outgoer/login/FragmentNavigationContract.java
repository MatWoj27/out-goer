package com.mattech.outgoer.login;

public interface FragmentNavigationContract {
    interface MvpView {
        void attachPresenter(MvpPresenter mvpPresenter);
    }

    interface MvpPresenter {
        void addFragment(BaseFragment fragment, LoginActivity.AnimationType animationType);
    }
}

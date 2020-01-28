package com.mattech.outgoer.login;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mattech.outgoer.R;
import com.mattech.outgoer.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends FragmentActivity implements SignInFragment.ActionPerformedListener, SignUpFragment.ActionPerformedListener {
    private AnimationDrawable animationDrawable;

    @BindView(R.id.login_layout)
    ViewGroup loginLayout;

    @BindView(R.id.login_frame)
    FrameLayout loginFrame;

    enum AnimationType {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        NO_ANIM
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        animationDrawable = (AnimationDrawable) loginLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(3500);
        if (savedInstanceState == null) {
            SignInFragment signInFragment = new SignInFragment();
            changeFragment(signInFragment, AnimationType.NO_ANIM, false);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        animationDrawable.start();
    }

    @Override
    public void signIn() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToSignUp() {
        SignUpFragment signUpFragment = new SignUpFragment();
        changeFragment(signUpFragment, AnimationType.LEFT_TO_RIGHT, true);
    }

    @Override
    public void goToResetPassword() {
        ResetPasswordFragment resetPasswordFragment = new ResetPasswordFragment();
        changeFragment(resetPasswordFragment, AnimationType.RIGHT_TO_LEFT, true);
    }

    @Override
    public void signUp() {
    }

    @Override
    public void goToSignIn() {
        SignInFragment signInFragment = new SignInFragment();
        changeFragment(signInFragment, AnimationType.RIGHT_TO_LEFT, true);
    }

    private void changeFragment(Fragment fragment, AnimationType animationType, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (animationType) {
            case LEFT_TO_RIGHT:
                ft.setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left,
                        R.anim.enter_left_to_right, R.anim.exit_left_to_right);
                break;
            case RIGHT_TO_LEFT:
                ft.setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right,
                        R.anim.enter_right_to_left, R.anim.exit_right_to_left);
                break;
        }
        ft.replace(R.id.login_frame, fragment);
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}
package com.mattech.outgoer.activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mattech.outgoer.R;
import com.mattech.outgoer.fragments.ResetPasswordFragment;
import com.mattech.outgoer.fragments.SignInFragment;
import com.mattech.outgoer.fragments.SignUpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements SignInFragment.ActionPerformedListener, SignUpFragment.ActionPerformedListener {
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

    private void changeFragment(android.support.v4.app.Fragment fragment, AnimationType animationType, boolean addToBackStack) {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
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

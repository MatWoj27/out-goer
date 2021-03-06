package com.mattech.outgoer.login.sign_up;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mattech.outgoer.R;
import com.mattech.outgoer.login.BaseFragment;
import com.mattech.outgoer.login.LoginActivity;
import com.mattech.outgoer.login.sign_in.SignInFragment;
import com.mattech.outgoer.utils.ViewAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpFragment extends BaseFragment implements SignUpContract.MvpView {
    private SignUpContract.MvpPresenter mvpPresenter;

    @BindView(R.id.mail)
    EditText mail;

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.repeat_password)
    EditText repeatPassword;

    @BindView(R.id.sign_up_btn)
    Button signUpBtn;

    @BindView(R.id.sign_in)
    TextView signIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        mvpPresenter = new SignUpPresenter(this);
        signIn.setOnClickListener(v -> navigationPresenter.addFragment(new SignInFragment(), LoginActivity.AnimationType.RIGHT_TO_LEFT));
        signUpBtn.setOnClickListener(v -> mvpPresenter.handleSignUpBtnClick(mail.getText().toString(),
                username.getText().toString(),
                password.getText().toString(),
                repeatPassword.getText().toString()));
        return view;
    }

    @Override
    public void displayEmptyEmailWarning() {
        ViewAnimator.animateViewShake(mail);
        Toast.makeText(getContext(), getResources().getString(R.string.no_mail_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayEmptyUsernameWarning() {
        ViewAnimator.animateViewShake(username);
        Toast.makeText(getContext(), getResources().getString(R.string.no_username_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayEmptyPasswordWarning() {
        ViewAnimator.animateViewShake(password);
        Toast.makeText(getContext(), getResources().getString(R.string.no_pass_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayEmptyRepeatedPasswordWarning() {
        ViewAnimator.animateViewShake(repeatPassword);
        Toast.makeText(getContext(), getResources().getString(R.string.no_repeat_pass_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayPasswordsNotMatchingWarning() {
        ViewAnimator.animateViewShake(password);
        ViewAnimator.animateViewShake(repeatPassword);
        Toast.makeText(getContext(), getResources().getString(R.string.different_passwords_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSignInScreen() {
        navigationPresenter.addFragment(new SignInFragment(), LoginActivity.AnimationType.RIGHT_TO_LEFT);
    }
}

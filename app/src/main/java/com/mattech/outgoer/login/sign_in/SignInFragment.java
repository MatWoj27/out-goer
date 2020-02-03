package com.mattech.outgoer.login.sign_in;

import android.content.Intent;
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
import com.mattech.outgoer.login.reset_password.ResetPasswordFragment;
import com.mattech.outgoer.login.sign_up.SignUpFragment;
import com.mattech.outgoer.main.MainActivity;
import com.mattech.outgoer.utils.ViewAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInFragment extends BaseFragment implements SignInContract.MvpView {
    private SignInContract.MvpPresenter mvpPresenter;

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.sign_in_btn)
    Button signInBtn;

    @BindView(R.id.forgot_password)
    TextView forgotPassword;

    @BindView(R.id.sign_up)
    TextView signUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        mvpPresenter = new SignInPresenter(this);
        signInBtn.setOnClickListener(v -> mvpPresenter.handleSignInBtnClick(username.getText().toString(),
                password.getText().toString()));
        signUp.setOnClickListener(v -> navigationPresenter.addFragment(new SignUpFragment(), LoginActivity.AnimationType.LEFT_TO_RIGHT));
        forgotPassword.setOnClickListener(v -> navigationPresenter.addFragment(new ResetPasswordFragment(), LoginActivity.AnimationType.RIGHT_TO_LEFT));
        return view;
    }

    @Override
    public void showMainScreen() {
        startActivity(new Intent(getContext(), MainActivity.class));
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
}

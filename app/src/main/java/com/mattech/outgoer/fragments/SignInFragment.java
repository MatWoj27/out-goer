package com.mattech.outgoer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mattech.outgoer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInFragment extends Fragment {
    ActionPerformedListener listener;

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

    public interface ActionPerformedListener {
        void signIn();

        void goToSignUp();

        void goToResetPassword();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActionPerformedListener) {
            listener = (ActionPerformedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " has to implement SignInFragment.ActionPerformedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        signInBtn.setOnClickListener(v -> {
            if (username.getText().toString().equals(""))
                Toast.makeText(getContext(), getResources().getString(R.string.no_username_error), Toast.LENGTH_SHORT).show();
            else if (password.getText().toString().equals(""))
                Toast.makeText(getContext(), getResources().getString(R.string.no_pass_error), Toast.LENGTH_SHORT).show();
            else
                listener.signIn();
        });
        signUp.setOnClickListener(v -> {
            if (listener != null)
                listener.goToSignUp();
        });
        forgotPassword.setOnClickListener(v -> {
            if (listener != null) {
                listener.goToResetPassword();
            }
        });
        return view;
    }
}

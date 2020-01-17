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

public class SignUpFragment extends Fragment {
    ActionPerformedListener listener;

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

    public interface ActionPerformedListener {
        void signUp();

        void goToSignIn();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActionPerformedListener) {
            listener = (ActionPerformedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " has to implement SignUpFragment.ActionPerformedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        signIn.setOnClickListener(v -> {
            if (listener != null)
                listener.goToSignIn();
        });
        signUpBtn.setOnClickListener(v -> {
            if (mail.getText().toString().isEmpty()) {
                //shake mail editTextView
                Toast.makeText(getContext(), getResources().getString(R.string.no_mail_error), Toast.LENGTH_SHORT).show();
            } else if (username.getText().toString().isEmpty()) {
                //shake username editTextView
                Toast.makeText(getContext(), getResources().getString(R.string.no_username_error), Toast.LENGTH_SHORT).show();
            } else if (password.getText().toString().isEmpty())
                Toast.makeText(getContext(), getResources().getString(R.string.no_pass_error), Toast.LENGTH_SHORT).show();
            else if (repeatPassword.getText().toString().isEmpty())
                Toast.makeText(getContext(), getResources().getString(R.string.no_repeat_pass_error), Toast.LENGTH_SHORT).show();
            else if (!password.getText().toString().equals(repeatPassword.getText().toString()))
                Toast.makeText(getContext(), getResources().getString(R.string.different_passwords_error), Toast.LENGTH_SHORT).show();
            else if (listener != null)
                listener.signUp();
        });
        return view;
    }
}

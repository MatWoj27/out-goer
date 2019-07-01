package com.mattech.outgoer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mattech.outgoer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpFragment extends android.support.v4.app.Fragment {
    ActionPerformedListener listener;

    @BindView(R.id.mail)
    EditText mail;

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
        if(context instanceof ActionPerformedListener){
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
                }
        );
        return view;
    }
}

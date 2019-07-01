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

public class SignInFragment extends android.support.v4.app.Fragment {
    ActionPerformedListener listener;

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.sign_in_btn)
    Button signInBtn;

    @BindView(R.id.sign_up)
    TextView signUp;

    public interface ActionPerformedListener {
        void signIn();
        void goToSignUp();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ActionPerformedListener){
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
        signUp.setOnClickListener(v -> {
                    if (listener != null)
                        listener.goToSignUp();
                }
        );
        return view;
    }
}

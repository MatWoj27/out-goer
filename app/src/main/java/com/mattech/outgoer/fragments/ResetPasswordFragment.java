package com.mattech.outgoer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mattech.outgoer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResetPasswordFragment extends Fragment {

    @BindView(R.id.reset_header)
    TextView resetHeader;

    @BindView(R.id.reset_info)
    TextView resetInfo;

    @BindView(R.id.new_password)
    EditText newPass;

    @BindView(R.id.mail)
    EditText mail;

    @BindView(R.id.send_reset_btn)
    Button sendBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);
        ButterKnife.bind(this, view);
        sendBtn.setOnClickListener(v -> {
            resetHeader.setText(getResources().getString(R.string.enter_reset_code));
            resetInfo.setText(getResources().getString(R.string.reset_code_info));
            mail.setHint(getResources().getString(R.string.reset_code_hint));
            sendBtn.setText(R.string.verify);
            sendBtn.setOnClickListener(vi -> {
                newPass.setVisibility(View.VISIBLE);
                mail.setHint(R.string.confirm_new_pass);
                sendBtn.setText(R.string.change);
            });
        });
        return view;
    }
}

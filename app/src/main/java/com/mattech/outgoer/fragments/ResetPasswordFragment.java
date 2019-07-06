package com.mattech.outgoer.fragments;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
    private PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1f);
    private PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 1f);
    private PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f);

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
        sendBtn.setOnClickListener(v -> arrangeResetCodeStep());
        return view;
    }

    private void animateTextChange(TextView textView, String newText) {
        ObjectAnimator.ofPropertyValuesHolder(textView, scaleX, scaleY, alpha).setDuration(300).start();
        textView.setText(newText);
    }

    private void arrangeResetCodeStep() {
        animateTextChange(resetHeader, getResources().getString(R.string.enter_reset_code));
        animateTextChange(resetInfo, getResources().getString(R.string.reset_code_info));
        mail.setHint(getResources().getString(R.string.reset_code_hint));
        animateTextChange(sendBtn, getResources().getString(R.string.verify));
        sendBtn.setOnClickListener(v -> arrangeChangePassStep());
    }

    private void arrangeChangePassStep() {
        animateTextChange(resetHeader, getResources().getString(R.string.reset_pass));
        animateTextChange(resetInfo, getResources().getString(R.string.reset_pass_info));
        newPass.setVisibility(View.VISIBLE);
        mail.setHint(R.string.confirm_new_pass);
        animateTextChange(sendBtn, getResources().getString(R.string.change));
    }
}

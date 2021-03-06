package com.mattech.outgoer.login.reset_password;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mattech.outgoer.R;
import com.mattech.outgoer.login.BaseFragment;
import com.mattech.outgoer.utils.ViewAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResetPasswordFragment extends BaseFragment implements ResetPasswordContract.MvpView {
    private ResetPasswordContract.MvpPresenter mvpPresenter;

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
        mvpPresenter = new ResetPasswordPresenter(this);
        sendBtn.setOnClickListener(v -> mvpPresenter.handleSendEmailBtnClick(mail.getText().toString()));
        return view;
    }

    @Override
    public void showResetCodeScreen() {
        animateTextChange(resetHeader, getResources().getString(R.string.enter_reset_code));
        animateTextChange(resetInfo, getResources().getString(R.string.reset_code_info));
        mail.setHint(getResources().getString(R.string.reset_code_hint));
        animateTextChange(sendBtn, getResources().getString(R.string.verify));
        sendBtn.setOnClickListener(v -> mvpPresenter.handleVerifyRestCodeBtnClick(mail.getText().toString()));
    }

    @Override
    public void showSetNewPasswordScreen() {
        animateTextChange(resetHeader, getResources().getString(R.string.reset_pass));
        animateTextChange(resetInfo, getResources().getString(R.string.reset_pass_info));
        newPass.setVisibility(View.VISIBLE);
        mail.setHint(R.string.confirm_new_pass);
        animateTextChange(sendBtn, getResources().getString(R.string.change));
        sendBtn.setOnClickListener(v -> mvpPresenter.handleConfirmPasswordChangeBtnClick(newPass.getText().toString(), mail.getText().toString()));
    }

    private void animateTextChange(TextView textView, String text) {
        ViewAnimator.animateViewBounce(textView);
        textView.setText(text);
    }
}

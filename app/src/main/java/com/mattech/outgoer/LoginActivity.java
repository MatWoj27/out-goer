package com.mattech.outgoer;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {

    @BindView(R.id.login_layout)
    LinearLayout loginLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        AnimationDrawable animationDrawable = (AnimationDrawable) loginLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(3500);
        animationDrawable.start();
    }
}

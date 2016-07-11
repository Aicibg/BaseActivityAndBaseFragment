package com.app.appbasedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @FileName: com.app.appbasedemo.LoginFragment.java
 * Description:登录fragment
 * Created by donghao on 2016/7/11.
 */
public class LoginFragment extends BaseFragment {
     private TextView tvBack,tvRegister,tvPromise;
     private EditText etUserName,etPassword;
     private Button btLogin;
     private String msg;

    public static final String FIRSTFRAGMENT="first_fragment";

    public static LoginFragment getInstance(String msg){
        LoginFragment fragment=new LoginFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable(FIRSTFRAGMENT,msg);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            msg= (String) getArguments().getSerializable(FIRSTFRAGMENT);
        }
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        tvBack= (TextView) view.findViewById(R.id.login_tv_back);
        tvPromise= (TextView) view.findViewById(R.id.login_tv_promise);
        tvRegister= (TextView) view.findViewById(R.id.login_tv_register);
        etPassword= (EditText) view.findViewById(R.id.login_et_password);
        etUserName= (EditText) view.findViewById(R.id.login_et_username);
        etUserName.setText(msg);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(RegisterFragment.getInstance("从登录界面跳转过来"));
            }
        });

        tvPromise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addFragment(PromisFragment.getInstance());
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }
}

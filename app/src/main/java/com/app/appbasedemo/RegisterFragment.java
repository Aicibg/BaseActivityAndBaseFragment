package com.app.appbasedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * @FileName: com.app.appbasedemo.RegisterFragment.java
 * Description:注册fragment
 * Created by donghao on 2016/7/11.
 */
public class RegisterFragment extends BaseFragment{
   private TextView mTextView,tvBack;
    private String msg;

    public static final String SECOND_FRAGMENT="second_fragment";

    public static RegisterFragment getInstance(String msg){
        RegisterFragment fragment=new RegisterFragment();
        Bundle data=new Bundle();
        data.putSerializable(SECOND_FRAGMENT,msg);
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            msg= (String) getArguments().getSerializable(SECOND_FRAGMENT);
        }
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        mTextView= (TextView) view.findViewById(R.id.register_tv_txt);
        tvBack= (TextView) view.findViewById(R.id.register_tv_back);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment();
            }
        });

        mTextView.setText(msg);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }
}

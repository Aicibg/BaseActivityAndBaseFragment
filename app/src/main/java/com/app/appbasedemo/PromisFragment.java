package com.app.appbasedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @FileName: com.app.appbasedemo.PromisFragment.java
 * Description:
 * Created by donghao on 2016/7/11.
 */
public class PromisFragment extends BaseFragment {
    private TextView tvBack;

    public static PromisFragment getInstance(){
        return new PromisFragment();
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        tvBack= (TextView) view.findViewById(R.id.promise_tv_back);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_promis;
    }
}

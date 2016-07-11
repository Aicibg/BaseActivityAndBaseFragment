package com.app.appbasedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @FileName: com.app.appbasedemo.BaseFragment.java
 * Description:
 * Created by donghao on 2016/7/11.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    protected abstract void initView(View view, Bundle saveInstanceState);
    //获取fragment布局文件id
    protected abstract int getLayoutId();
    //获取宿主Activity
    protected BaseActivity getHoldingActivity(){
        return mActivity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity= (BaseActivity) context;
    }

    //添加fragment
    protected void addFragment(BaseFragment fragment){
        if(fragment!=null){
            getHoldingActivity().addFragment(fragment);
        }
    }
    //移除fragment
    protected  void removeFragment(){
        getHoldingActivity().removeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(getLayoutId(),container,false);
        initView(view,savedInstanceState);
        return view;
    }
}

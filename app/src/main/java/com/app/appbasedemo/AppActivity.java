package com.app.appbasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @FileName: com.app.appbasedemo.AppActivity.java
 * Description:
 * Created by donghao on 2016/7/11.
 */
public abstract class AppActivity extends BaseActivity{
    @Override
    protected int getContentId() {
        return R.layout.activity_base;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }

    //获取第一个Fragment
    protected abstract BaseFragment getFirstFrsgment();
    //获取intent
    protected void handlerIntent(Intent intent){

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentId());
        if(getIntent()!=null){
            handlerIntent(getIntent());
        }
        //避免重复添加Fragment
        if(getSupportFragmentManager().getFragments()==null){
            BaseFragment fragment=getFirstFrsgment();
            if(fragment!=null){
                addFragment(fragment);
            }
        }
    }
}

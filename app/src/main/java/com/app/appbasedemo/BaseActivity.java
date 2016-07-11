package com.app.appbasedemo;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * @FileName: com.app.appbasedemo.BaseActivity.java
 * Description:
 * Created by donghao on 2016/7/11.
 */
public abstract class BaseActivity extends AppCompatActivity {
    //布局文件id
    protected abstract int getContentId();
    //布局中的fragmentid
    protected abstract int getFragmentContentId();

    //添加fragment
    protected void addFragment(BaseFragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(),fragment,fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    //移除fragment
    protected void removeFragment(){
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }
   //返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(getSupportFragmentManager().getBackStackEntryCount()==1){
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.app.appbasedemo;

import android.content.Intent;
import android.os.Bundle;

/**
 * @FileName: com.app.appbasedemo.LoginActivity.java
 * Description:
 * Created by donghao on 2016/7/11.
 */
public class LoginActivity extends AppActivity {
    private String userName;

    @Override
    protected void handlerIntent(Intent intent) {
        super.handlerIntent(intent);
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            userName=bundle.getString("username");
        }

    }

    @Override
    protected BaseFragment getFirstFrsgment() {
        return LoginFragment.getInstance(userName);
    }
}

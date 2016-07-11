package com.app.appbasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @FileName: com.app.appbasedemo.MainFragment.java
 * Description:
 * Created by donghao on 2016/7/11.
 */
public class MainFragment extends BaseFragment {

    private Button btnMainLogin,BtnMainRegist,BtnMainTab;

    public static MainFragment getInstance(){
        return new MainFragment();
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        btnMainLogin= (Button) view.findViewById(R.id.main_btn_login);
        btnMainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data=new Bundle();
                data.putString("username","donghao");
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });

        BtnMainRegist= (Button) view.findViewById(R.id.main_btn_regist);
        BtnMainRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addFragment(RegisterFragment.getInstance("从首页跳转过来"));
            }
        });

        BtnMainTab= (Button) view.findViewById(R.id.main_btn_tablayout);
        BtnMainTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}

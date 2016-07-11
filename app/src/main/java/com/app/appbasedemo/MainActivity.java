package com.app.appbasedemo;

public class MainActivity extends AppActivity {

    @Override
    protected BaseFragment getFirstFrsgment() {
        return MainFragment.getInstance();
    }
}

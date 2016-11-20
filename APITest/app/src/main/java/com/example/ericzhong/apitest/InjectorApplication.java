package com.example.ericzhong.apitest;

import android.app.Application;

/**
 * Created by Eric Zhong on 2016/11/20.
 */

public class InjectorApplication extends Application {
    private InjectorComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = createComponent();

    }

    public InjectorComponent createComponent(){
        return DaggerApplicationComponent.builder()
                .injector(new Injector()).build();
    }

    public InjectorComponent getComponent(){
        return component;
    }
}

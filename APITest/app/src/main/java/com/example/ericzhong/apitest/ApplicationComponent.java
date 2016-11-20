package com.example.ericzhong.apitest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eric Zhong on 2016/11/20.
 */

@Singleton
@Component(modules = {Injector.class})
public interface ApplicationComponent extends InjectorComponent {
}

package com.zdh.study.ui.design.observer;

import java.util.ArrayList;
import java.util.List;

/*
 * @author mousse
 * @emil zdonghao0104@163.com
 * create time 2023/3/21 13:51
 * description:具体被观察者：微信公众号
 */
public class SubscriptionSubject implements Subject {
    //存储订阅公众号的微信用户
    private List<Observer> weiXinUserList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weiXinUserList) {
            observer.update(message);
        }
    }
}

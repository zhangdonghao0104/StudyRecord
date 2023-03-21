package com.zdh.study.ui.design.proxy;
/*
* @author mousse
* create time 2023/3/21 10:11
* description:代理类
* 购买者找的代理类，同样要实现shop接口，并且要持有被代理者，在buy方法中调用了被代理者的buy方法
*/
public class Purchaser implements IShop{

    private IShop mShop;

    public Purchaser (IShop shop){
        this.mShop = shop;
    }
    @Override
    public void buy() {
        mShop.buy();
    }
}

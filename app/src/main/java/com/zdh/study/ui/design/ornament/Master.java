package com.zdh.study.ui.design.ornament;

/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 11:03
* description:抽象装饰者，保持了一个对抽象组件的引用方便调用被装饰对象的方法（武学高手要持有对大侠的引用，方便教授他武功）
*/
public abstract class Master extends Swordsman{
    private Swordsman mSwordsman;
    public Master (Swordsman swordsman){
        this.mSwordsman = swordsman;
    }

    @Override
    public void attackMagic() {
        mSwordsman.attackMagic();
    }
}

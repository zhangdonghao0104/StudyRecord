package com.zdh.study.ui.design.strategy;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 13:15
* description:第三步：上下文角色的构造方法包含策略类，通过传进来不同的具体策略来调用不同策略的fighting方法
*/
public class StrategyContext {

    private FightingStrategy fightingStrategy;

    public StrategyContext (FightingStrategy fightingStrategy){
        this.fightingStrategy = fightingStrategy;
    }

    public void fighting(){
        fightingStrategy.fighting();
    }
}

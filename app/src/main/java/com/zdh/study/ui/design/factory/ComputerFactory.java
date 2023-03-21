package com.zdh.study.ui.design.factory;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 16:35
* description:工厂方法模式有以下角色
* 1.Product:抽象产品类
* 2.ConcreteProduct:具体产品类，实现Product接口
* 3.Factory:抽象工厂类，该方法返回一个product类型的对象
* 4.ConcreteFactory:具体工厂类，返回ConcreteProduct实例
* 这里创建抽象工厂
*/
public abstract class ComputerFactory {
    public abstract <T extends Computer> T createComputer(Class<T> clz);
}

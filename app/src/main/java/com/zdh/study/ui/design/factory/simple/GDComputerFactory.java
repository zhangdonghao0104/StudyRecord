package com.zdh.study.ui.design.factory.simple;

import com.zdh.study.ui.design.factory.Computer;
import com.zdh.study.ui.design.factory.ComputerFactory;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 16:48
* description:创建具体工厂，继承自抽象工厂，通过反射生产不同的product对象
*/
public class GDComputerFactory extends ComputerFactory {
    @Override
    public <T extends Computer> T createComputer(Class<T> clz) {

        Computer computer = null;
        String className = clz.getName();
        try {
            computer = (Computer) Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T)computer;
    }
}

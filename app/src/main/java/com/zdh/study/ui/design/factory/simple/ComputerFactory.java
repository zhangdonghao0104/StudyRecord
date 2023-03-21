package com.zdh.study.ui.design.factory.simple;

import com.zdh.study.ui.design.factory.AsusComputer;
import com.zdh.study.ui.design.factory.Computer;
import com.zdh.study.ui.design.factory.HpComputer;
import com.zdh.study.ui.design.factory.LenovoComputer;

/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 13:15
* description:工厂类-提供静态方法-生产产品类
*/
public class ComputerFactory {

    public static Computer createComputer(String type){
        Computer computer = null;
        switch (type){
            case "lenovo":
                computer = new LenovoComputer();
                break;

            case "hp":
                computer = new HpComputer();
                break;

            case "asus":
                computer = new AsusComputer();
                break;
        }
        return computer;
    }

}

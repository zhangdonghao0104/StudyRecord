package com.zdh.study.ui.design.build;

/*
 * @author mousse
 * @emil zdonghao0104@163.com
 * create time 2023/3/21 8:57
 * description:建造者模式：产品类
 */
public class Computer {
    private String cpu;
    private String mainBoard;
    private String ram;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}

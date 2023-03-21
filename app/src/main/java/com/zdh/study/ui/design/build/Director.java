package com.zdh.study.ui.design.build;

/*
 * @author mousse
 * @emil zdonghao0104@163.com
 * create time 2023/3/21 9:05
 * description:导演类：负责安排已有模块的顺序，通知builder开始创建
 */
public class Director {

    Builder mBuilder = null;

    public Director(Builder builder) {
        this.mBuilder = builder;
    }

    public Computer CreateComputer(String cpu, String mainBoard, String ram) {
        this.mBuilder.builderCpu(cpu);
        this.mBuilder.builderMainBoard(mainBoard);
        this.mBuilder.builderRam(ram);
        return mBuilder.create();
    }

}

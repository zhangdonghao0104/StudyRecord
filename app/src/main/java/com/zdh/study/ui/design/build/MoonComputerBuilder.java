package com.zdh.study.ui.design.build;

/*
 * @author mousse
 * @emil zdonghao0104@163.com
 * create time 2023/3/21 9:03
 * description:实现抽象builder类,用于组装计算机
 */
public class MoonComputerBuilder extends Builder {
    private Computer mComputer = new Computer();

    @Override
    public void builderCpu(String cpu) {
        mComputer.setCpu(cpu);
    }

    @Override
    public void builderMainBoard(String mainBoard) {
        mComputer.setMainBoard(mainBoard);
    }

    @Override
    public void builderRam(String ram) {
        mComputer.setRam(ram);
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}

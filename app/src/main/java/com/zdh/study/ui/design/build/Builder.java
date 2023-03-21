package com.zdh.study.ui.design.build;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 9:00
* description:builder类：规范产品的创建
*/
public abstract class Builder {
    public abstract void builderCpu (String cpu);
    public abstract void builderMainBoard (String mainBoard);
    public abstract void builderRam (String ram);
    public abstract Computer create();
}

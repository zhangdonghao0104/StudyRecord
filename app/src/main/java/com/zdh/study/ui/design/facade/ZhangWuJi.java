package com.zdh.study.ui.design.facade;

/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 11:35
* description:外观类，负责将招式，内功合理的运用
*/
public class ZhangWuJi {

    private JingMai jingMai;
    private NeiGong neiGong;
    private ZhaoShi zhaoShi;
    public ZhangWuJi(){
        jingMai = new JingMai();
        neiGong = new NeiGong();
        zhaoShi = new ZhaoShi();
    }
    //使用乾坤大挪移
    public void QianKun(){
        jingMai.jingMai();//开启经脉
        neiGong.QianKun();//使用乾坤大挪移
    }
    //使用七伤拳
    public void QiShangQuan(){
        jingMai.jingMai();
        zhaoShi.QiShangQuan();
        neiGong.JiuYang();
    }
}

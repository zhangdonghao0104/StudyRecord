package com.zdh.study.ui.design.ornament;

import android.util.Log;

/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 11:01
* description:组件具体实现类
* 被装饰的具体对象，在这里就是被教授武学的具体大侠，
*/
public class YangGuo extends Swordsman{
    @Override
    public void attackMagic() {
        Log.e("TAG","杨过初始学的基本武功:全真剑法");
    }
}

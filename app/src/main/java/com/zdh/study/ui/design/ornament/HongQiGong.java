package com.zdh.study.ui.design.ornament;

import android.util.Log;

/*
 * @author mousse
 * @emil zdonghao0104@163.com
 * create time 2023/3/21 11:06
 * description:装饰着的具体实现类，这里是洪七公，负责向杨过传授新的武功
 */
public class HongQiGong extends Master {


    public HongQiGong(Swordsman swordsman) {
        super(swordsman);
    }

    public void teacherAttackMagic() {
        Log.e("TAG", "洪七公教授九阴真经");
        Log.e("TAG", "杨过使用九阴真经");
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teacherAttackMagic();
    }
}

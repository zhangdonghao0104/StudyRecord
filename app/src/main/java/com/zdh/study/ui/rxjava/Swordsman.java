package com.zdh.study.ui.rxjava;

public class Swordsman {
    private String name;
    private String lev;

    public Swordsman(String name, String lev) {
        this.name = name;
        this.lev = lev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }
}

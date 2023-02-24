package org.zywang.myspring.test.bean;

public class Wife {

    private Husband husband;
    private IMother mother; // grandmother

    public String queryHusband() {
        return "Wife.husband, Mother.callMother:" + mother.callMother();
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public IMother getMother() {
        return mother;
    }

    public void setMother(IMother mother) {
        this.mother = mother;
    }
}
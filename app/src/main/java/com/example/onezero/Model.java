package com.example.onezero;

public class Model

{
    String nomi,manzili,raqami,joylashuvi;

    public Model() {
    }

    public Model(String nomi, String manzili, String raqami, String joylashuvi) {
        this.nomi = nomi;
        this.manzili = manzili;
        this.raqami = raqami;
        this.joylashuvi = joylashuvi;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public String getManzili() {
        return manzili;
    }

    public void setManzili(String manzili) {
        this.manzili = manzili;
    }

    public String getRaqami() {
        return raqami;
    }

    public void setRaqami(String raqami) {
        this.raqami = raqami;
    }

    public String getJoylashuvi() {
        return joylashuvi;
    }

    public void setJoylashuvi(String joylashuvi) {
        this.joylashuvi = joylashuvi;
    }
}

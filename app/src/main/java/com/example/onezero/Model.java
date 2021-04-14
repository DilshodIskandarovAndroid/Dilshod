package com.example.onezero;

public class Model

{
    String Nomi,manzili,raqami,joylashuvi;

    public Model() {
    }

    public Model(String Nomi, String manzili, String raqami, String joylashuvi) {
        this.Nomi = Nomi;
        this.manzili = manzili;
        this.raqami = raqami;
        this.joylashuvi = joylashuvi;
    }

    public String getNomi() {
        return Nomi;
    }

    public void setNomi(String Nomi) {
        this.Nomi = Nomi;
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

package com.putraprima.ppmsqliteexamplefirst.models;

import com.orm.SugarRecord;

/**
 * Created by root on 10/26/17.
 */

public class Pengarang extends SugarRecord<Pengarang> {
    public String nama;
    public String umur;
    public String jk;

    public Pengarang(String nama, String umur, String jk) {
        this.nama = nama;
        this.umur = umur;
        this.jk = jk;
    }

    public Pengarang(){

    }

    public String getNama() {
        return nama;
    }

    public String getUmur() {
        return umur;
    }

    public String getJk() {
        return jk;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }
}

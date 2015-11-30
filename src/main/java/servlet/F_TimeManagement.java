/*
 * Copyright (C) 2015 inchidi
 *
 * This program is created and owned by dimas ari ;
 * you CAN NOT redistribute it and/or modify it without owner permit
 * Inchidi, Samarinda, Kalimantan Timur, +62812 7777 9663, Indonesia.
 */
package servlet;

import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author inchidi
 */
public class F_TimeManagement extends F_Koneksi {

    private static final Logger LOG = getLogger(F_TimeManagement.class.getName());

    Calendar c;

    /**
     *
     * @param c
     * @return
     */
    public String getTanggalS(Calendar c){
        String STanggal = "";
        int Tanggal = c.get(DATE);
        int puluhan =Tanggal;
        if( puluhan == 10){
            STanggal +=" sepuluh";
        }else if( puluhan == 20){
            STanggal +=" dua puluh";
        }else if( puluhan == 30){
            STanggal +=" tiga puluh";
        }else if(puluhan<10){
            STanggal +=intToString(Tanggal-((Tanggal/10)*10));
        }else if(puluhan<20){
            STanggal +=" "+intToString(Tanggal-((Tanggal/10)*10))+" belas";
        } else{// x puluh y
            STanggal +=intToString(puluhan/10)+" puluh "+intToString(Tanggal-((Tanggal/10)*10));
        }
        return STanggal;
    }

    /**
     *
     * @param c
     * @return
     */
    public int getTanggal(Calendar c) {
        return c.get(DATE);
    }

    /**
     *
     * @param c
     * @return
     */
    public String getHari(Calendar c) {
        String Hari;
        switch (c.get(DAY_OF_WEEK)) {
            case 2:
                Hari = "Senin";
                break;
            case 3:
                Hari = "Selasa";
                break;
            case 4:
                Hari = "Rabu";
                break;
            case 5:
                Hari = "Kamis";
                break;
            case 6:
                Hari = "Jumat";
                break;
            case 7:
                Hari = "Sabtu";
                break;
            case 1:
                Hari = "Minggu";
                break;
            default:
                Hari = ".........";
        }
        return Hari;
    }

    /**
     *
     * @param c
     * @return
     */
    public String getBulan(Calendar c) {
        String Bulan;
        switch (c.get(MONTH)) {
            case 0:
                Bulan = "Januari";
                break;
            case 1:
                Bulan = "Februari";
                break;
            case 2:
                Bulan = "Maret";
                break;
            case 3:
                Bulan = "April";
                break;
            case 4:
                Bulan = "Mei";
                break;
            case 5:
                Bulan = "Juni";
                break;
            case 6:
                Bulan = "Juli";
                break;
            case 7:
                Bulan = "Agustus";
                break;
            case 8:
                Bulan = "September";
                break;
            case 9:
                Bulan = "Oktober";
                break;
            case 10:
                Bulan = "November";
                break;
            case 11:
                Bulan = "Desember";
                break;
            default:
                Bulan = "............";
        }
        return Bulan;
    }

    /**
     *
     * @param i
     * @return
     */
    public String getBulan(int i) {
        String Bulan;
        switch (i) {
            case 0:
                Bulan = "Januari";
                break;
            case 1:
                Bulan = "Februari";
                break;
            case 2:
                Bulan = "Maret";
                break;
            case 3:
                Bulan = "April";
                break;
            case 4:
                Bulan = "Mei";
                break;
            case 5:
                Bulan = "Juni";
                break;
            case 6:
                Bulan = "Juli";
                break;
            case 7:
                Bulan = "Agustus";
                break;
            case 8:
                Bulan = "September";
                break;
            case 9:
                Bulan = "Oktober";
                break;
            case 10:
                Bulan = "November";
                break;
            case 11:
                Bulan = "Desember";
                break;
            default:
                Bulan = "............";
        }
        return Bulan;
    }

    /**
     *
     * @param c
     * @return
     */
    public String getTahun(Calendar c) {
        String STahun = "";
        int tahun = c.get(YEAR);
        if(tahun/100==20){STahun="dua ribu ";}
        int puluhan =tahun-((tahun/100)*100);
        if( puluhan == 10){
            STahun +="sepuluh";
        }else if(puluhan<10){
            STahun +=intToString(tahun-((tahun/10)*10));
        } else if(puluhan<20){
            STahun +=intToString(tahun-((tahun/10)*10))+" belas";
        }
        else {// x puluh y
            STahun +=intToString(puluhan/10)+" puluh "+intToString(tahun-((tahun/10)*10));
        }
        return STahun;
    }

    /**
     *
     * @param c
     * @return
     */
    public int getTahunint(Calendar c){
        return c.get(YEAR);
    }

    private String intToString(int i) {
        switch (i) {
            case 1:
                return "satu";
            case 2:
                return "dua";
            case 3:
                return "tiga";
            case 4:
                return "empat";
            case 5:
                return "lima";
            case 6:
                return "enam";
            case 7:
                return "tujuh";
            case 8:
                return "delapan";
            case 9:
                return "sembilan";
            default:
                return "";
        }
    }
}

package com.example.firstproject;

import android.net.Uri;

public class item {

    Uri 이미지_arr;
    String 제목_arr;
    String 위치_arr;
    String 건물_arr;
    String 가격_arr;

    public item(Uri 이미지_arr, String 제목_arr, String 위치_arr, String 건물_arr, String 가격_arr) {
        this.이미지_arr = 이미지_arr;
        this.제목_arr = 제목_arr;
        this.위치_arr = 위치_arr;
        this.건물_arr = 건물_arr;
        this.가격_arr = 가격_arr;
    }

    public Uri get이미지_arr() {
        return 이미지_arr;
    }

    public void set이미지_arr(Uri 이미지_arr) {
        this.이미지_arr = 이미지_arr;
    }

    public String get제목_arr() {
        return 제목_arr;
    }

    public void set제목_arr(String 제목_arr) {
        this.제목_arr = 제목_arr;
    }

    public String get위치_arr() {
        return 위치_arr;
    }

    public void set위치_arr(String 위치_arr) {
        this.위치_arr = 위치_arr;
    }

    public String get건물_arr() {
        return 건물_arr;
    }

    public void set건물_arr(String 건물_arr) {
        this.건물_arr = 건물_arr;
    }

    public String get가격_arr() {
        return 가격_arr;
    }

    public void set가격_arr(String 가격_arr) {
        this.가격_arr = 가격_arr;
    }
}

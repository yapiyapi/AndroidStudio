package com.example.firstproject;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class data {
    private static Uri uri_data = Uri.parse(String.valueOf(R.drawable.dabang));
    static ArrayList<Uri> 이미지_arr = new ArrayList<Uri>(Arrays.asList(
            uri_data,uri_data,uri_data,uri_data,uri_data));
    static ArrayList<String> 제목_arr = new ArrayList<>(Arrays.asList(
            "부산의 중심지 롯데캐슬","선수촌 아파트 급매!!","제니스 좋은 가격","부산 유일 유토피아","환상의 도시 부산"));
    static ArrayList<String> 위치_arr = new ArrayList<>(Arrays.asList(
            "반여1동","반여2동","반여3동","반여4동","반여5동"));
    static ArrayList<String> 건물_arr = new ArrayList<>(Arrays.asList(
            "센텀 롯데 캐슬","아시아 선수촌","제니스","아이파크","더 샵"));
    static ArrayList<String> 가격_arr = new ArrayList<>(Arrays.asList(
            "300/10","300/20","300/25","300/30","300/40"));
    static ArrayList<String> 내용_arr = new ArrayList<>(Arrays.asList(
            "안녕하세요","안녕하세요","안녕하세요","안녕하세요","안녕하세요"));
    static ArrayList<Boolean> 관심여부_arr = new ArrayList<>(Arrays.asList(
            false,false,false,false,false));
    static ArrayList<Boolean> 작성여부_arr = new ArrayList<>(Arrays.asList(
            false,false,false,false,false));
}
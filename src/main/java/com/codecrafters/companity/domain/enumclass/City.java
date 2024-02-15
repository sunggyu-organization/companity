package com.codecrafters.companity.domain.enumclass;

public enum City {
    Seoul(0 ,"서울시"),
    Busan(1 ,"부산시"),
    Daegu(2 ,"대구시"),
    Gwangju(3 ,"광주시"),
    Ulsan(4 ,"울산시"),
    Daejun(5 ,"대전시"),
    Gyeonggi(6 ,"경기도"),
    Gangwon(7 ,"강원도"),
    Chungnam(8 ,"충청남도"),
    Chungbuk(9 ,"충청북도"),
    Gyeongbuk(10 ,"경상북도"),
    Gyeongnam(11 ,"경상남도"),
    Jeonbuk(12 ,"전라북도"),
    Jeonnam(13 ,"전라남도"),
    Jeju(14 ,"제주도");

    int no;
    String value;

    City(int no, String value) {
        this.no = no;
        this.value = value;
    }
}

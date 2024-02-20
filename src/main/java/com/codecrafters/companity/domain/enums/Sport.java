package com.codecrafters.companity.domain.enums;

public enum Sport {
    Badminton(0 ,"배드민턴"),
    Baseball(1 ,"야구"),
    Basketball(2 ,"농구"),
    Billiards(3 ,"당구"),
    Bowling(4 ,"볼링"),
    Soccer(5 ,"축구"),
    Running(6 ,"런닝");

    final int no;
    final String value;

    Sport(int no, String value) {
        this.no = no;
        this.value = value;
    }
}

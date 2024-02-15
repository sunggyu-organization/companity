package com.codecrafters.companity.domain.enumclass;

public enum SportType {
    Badminton(0 ,"배드민턴"),
    Baseball(1 ,"야구"),
    Basketball(2 ,"농구"),
    Billiards(3 ,"당구"),
    Bowling(4 ,"볼링"),
    Soccer(5 ,"축구"),
    Running(6 ,"런닝");

    int no;
    String value;

    SportType(int no, String value) {
        this.no = no;
        this.value = value;
    }
}

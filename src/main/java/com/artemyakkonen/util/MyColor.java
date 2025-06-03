package com.artemyakkonen.util;

public class MyColor {
    static final String RESET = "\u001B[0m";
    static final String BLACK = "\033[0;30m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String BLUE = "\u001B[34m";
    static final String YELLOW_BG = "\u001B[43m";
    static final String BLUE_BG = "\u001B[44m";

    public static String color(String text){
        return BLACK + BLUE_BG + text + RESET;
    }
}

package com.lsidorki;

import java.util.function.BinaryOperator;

// 3
public class TypeInterfaceExample {

    public static void main(String[] args) {
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
//        BinaryOperator add = (x, y) -> x + y;
    }
}

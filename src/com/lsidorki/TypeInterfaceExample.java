package com.lsidorki;

import java.util.function.BinaryOperator;

/**
 * Example 3
 */
public class TypeInterfaceExample {

    public static void main(String[] args) {
        BinaryOperator<Long> addLongs = (Long x, Long y) -> x + y;
//        BinaryOperator add = (x, y) -> x + y;
    }
}

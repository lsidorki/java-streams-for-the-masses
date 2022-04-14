package com.lsidorki;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Example 2
 */
public class LambdaInnerVarExample {

    public static void main(String[] args) {
        JButton button = new JButton();
        final String name = "UserName";
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("hi " + name);
            }
        });
    }

    private static String formatName(String name) {
        return name.toUpperCase(Locale.ROOT);
    }
}

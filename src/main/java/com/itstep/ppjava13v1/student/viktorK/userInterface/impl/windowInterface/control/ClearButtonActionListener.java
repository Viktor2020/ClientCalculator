package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by on 15.12.2014.
 * Очищаем поле ввода
 */
public class ClearButtonActionListener implements ActionListener {

    private JTextField textField;

    public ClearButtonActionListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        textField.setText("");

    }
}

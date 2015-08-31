package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by on 18.12.2014.
 * Очищаем последний введенный символ в поле ввода
 */
public class ClearOneButtonActionListener implements ActionListener {

    private JTextField textField;

    public ClearOneButtonActionListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!textField.getText().isEmpty()){
            StringBuffer stringBuffer = new StringBuffer(textField.getText());

            stringBuffer.deleteCharAt(stringBuffer.length()-1);

            textField.setText(String.valueOf(stringBuffer));
        }

    }
}

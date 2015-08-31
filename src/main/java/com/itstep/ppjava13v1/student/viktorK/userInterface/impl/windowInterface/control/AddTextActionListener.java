package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by on 15.12.2014.
 * Добавляем текст кнопки в поле
 */
public class AddTextActionListener implements ActionListener{

    private JButton button;

    private JTextField  textField;

    public AddTextActionListener(JButton button, JTextField textField) {
        this.button = button;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        textField.setText(textField.getText() + button.getText());
        textField.setText(textField.getText().replace(" ",""));

    }
}

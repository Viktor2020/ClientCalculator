package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control;

import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectCore;
import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectionToTheServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by on 15.12.2014.
 * Посылаем запрос и в поле ввода вставляем ответ
 */
public class AnswerCalculatorActionListener  implements ActionListener{

    private JTextField textField;
    private ConnectCore connectCore;

    public AnswerCalculatorActionListener(JTextField textField,ConnectCore connectCore) {
        this.connectCore = connectCore;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                textField.setText(connectCore.send(textField.getText()));
            }
        }).start();

    }
}

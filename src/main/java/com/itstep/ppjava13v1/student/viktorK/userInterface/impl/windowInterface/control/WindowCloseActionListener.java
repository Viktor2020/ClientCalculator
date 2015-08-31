package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by on 15.12.2014.
 */
public class WindowCloseActionListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent event) {
        Object[] options = { "Да ", "Нет" };
        int n = JOptionPane.showOptionDialog(
                event.getWindow(),
                "Закрыть программу?",
                "Подтверждение",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (n == 0) {
            event.getWindow().setVisible(false);
            System.exit(0);
        }
    }
}

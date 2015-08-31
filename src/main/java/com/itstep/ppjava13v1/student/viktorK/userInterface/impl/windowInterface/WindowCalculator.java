package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface;

import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectCore;
import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectionToTheServer;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control.*;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.menu.MenuBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by on 14.01.2015.
 *
 * @author Viktor
 */
public class WindowCalculator {

    private JFrame frame;

    private ConnectCore connectCore;

    public WindowCalculator(ConnectCore connectCore) {
        if (connectCore == null) {
            this.connectCore = new ConnectionToTheServer();// default connect
        } else {
            this.connectCore = connectCore;
        }

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowCloseActionListener());
        frame.setSize(new Dimension(500, 500));

        JMenuBar menuBar = new MenuBar(connectCore, frame);

        frame.setJMenuBar(menuBar);

        init();

        frame.setVisible(true);
        frame.pack();
    }

    private void init() {

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(350, 200));
        mainPanel.setBackground(new Color(213, 226, 240));

        JTextField textField = new JTextField(16);
        textField.setHorizontalAlignment(SwingConstants.TRAILING);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        JButton buttonPoint = new JButton(".");
        JButton buttonClear = new JButton("C");
        JButton buttonDiv = new JButton("/");
        JButton buttonMul = new JButton("*");
        JButton buttonMin = new JButton("-");
        JButton buttonSum = new JButton("+");
        JButton buttonIs = new JButton("=");
        JButton buttonStat = new JButton("Statistic");
        JButton buttonClearOneChar = new JButton("<-");
        JButton buttonPM = new JButton("+-");

        buttonStat.addActionListener(new StatisticActionListener(connectCore));

        button1.addActionListener(new AddTextActionListener(button1, textField));
        button2.addActionListener(new AddTextActionListener(button2, textField));
        button3.addActionListener(new AddTextActionListener(button3, textField));
        button4.addActionListener(new AddTextActionListener(button4, textField));
        button5.addActionListener(new AddTextActionListener(button5, textField));
        button6.addActionListener(new AddTextActionListener(button6, textField));
        button7.addActionListener(new AddTextActionListener(button7, textField));
        button8.addActionListener(new AddTextActionListener(button8, textField));
        button9.addActionListener(new AddTextActionListener(button9, textField));
        button0.addActionListener(new AddTextActionListener(button0, textField));
        buttonPoint.addActionListener(new AddTextActionListener(buttonPoint, textField));

        buttonDiv.addActionListener(new AddTextActionListener(buttonDiv, textField));
        buttonMul.addActionListener(new AddTextActionListener(buttonMul, textField));
        buttonMin.addActionListener(new AddTextActionListener(buttonMin, textField));
        buttonSum.addActionListener(new AddTextActionListener(buttonSum, textField));

        buttonIs.addActionListener(new AnswerCalculatorActionListener(textField, connectCore));
        buttonClear.addActionListener(new ClearButtonActionListener(textField));
        buttonClearOneChar.addActionListener(new ClearOneButtonActionListener(textField));


        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonDiv);

        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonMul);

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonMin);

        buttonPanel.add(button0);
        buttonPanel.add(buttonPoint);
        buttonPanel.add(buttonClear);
        buttonPanel.add(buttonSum);

        buttonPanel.add(buttonStat);
        buttonPanel.add(buttonClearOneChar);
        buttonPanel.add(buttonPM);
        buttonPanel.add(buttonIs);


        mainPanel.add(textField, BorderLayout.PAGE_START);
        mainPanel.add(buttonPanel);
        frame.add(mainPanel);
        frame.pack();
    }
}


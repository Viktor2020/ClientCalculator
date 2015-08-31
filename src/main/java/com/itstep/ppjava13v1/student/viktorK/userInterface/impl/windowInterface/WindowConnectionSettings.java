package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface;

import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectServer;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by on 14.01.2015.
 * Window settings for connecting to the server.
 *
 * @author Viktor
 */
public class WindowConnectionSettings {

    public WindowConnectionSettings(ConnectServer theServer) {

        JFrame frame = new JFrame("Connection settings to the server");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(new DimensionUIResource(320, 130));

        JLabel portLabel = new JLabel("Port: ");
        JTextField portTextField = new JTextField("3128", 10);

        JLabel hostLabel = new JLabel("Host: ");
        JTextField hostTextField = new JTextField("localhost", 10);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                theServer.setSocket(new Socket(hostTextField.getText(), Integer.parseInt(portTextField.getText())));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }).start();
                } finally {
                    frame.dispose();
                }
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel portPanel = new JPanel();
        portPanel.add(portLabel);
        portPanel.add(portTextField);

        JPanel hostPanel = new JPanel();
        hostPanel.add(hostLabel);
        hostPanel.add(hostTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        frame.add(portPanel, BorderLayout.PAGE_START);
        frame.add(hostPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.PAGE_END);

//        frame.pack();
        frame.setVisible(true);

    }
}

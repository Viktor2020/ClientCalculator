package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.menu;

import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectCore;
import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectToTheClient;
import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectionToTheServer;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.WindowCalculator;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.WindowConnectionSettings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by on 14.01.2015.
 *
 * @author Viktor
 */
public class MenuBar extends JMenuBar{

    private ConnectCore connectCore;
    private JFrame frameCalculator;

    public MenuBar(ConnectCore connectCore,JFrame frameCalculator) {
        this.connectCore = connectCore;
        this.frameCalculator = frameCalculator;

        init();
    }

    private void init() {
        JMenu optionMenu = getOptionMenu();
        JMenu fileMenu = getFileMenu();
        JMenu helpMenu = getMyHelpMenu();

        add(fileMenu);
        add(optionMenu);
        add(helpMenu);
    }

    private JMenu getMyHelpMenu(){
        JMenu helpMenu = new JMenu("Help");

        JMenuItem about = new JMenuItem("About");

        helpMenu.add(about);

        return helpMenu;
    }

    private JMenu getFileMenu(){
        JMenu fileMenu = new JMenu("File");

        JMenuItem closeProgram = new JMenuItem("Close");

        fileMenu.add(closeProgram);

        return fileMenu;
    }

    private JMenu getOptionMenu(){
        JMenu optionMenu = new JMenu("Option");

        JMenu connectCore = getConnectCore();

        optionMenu.add(connectCore);

        return optionMenu;
    }

    private JMenu getConnectCore(){
        JMenu connectCore = new JMenu("Connect");

        JMenuItem connectServer = new JMenuItem("Server");
        connectServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCalculator.dispose();
                ConnectionToTheServer theServer = new ConnectionToTheServer();
                new WindowConnectionSettings(theServer);
                new WindowCalculator(theServer);
            }
        });
        JMenuItem connectClient = new JMenuItem("Client");
        connectClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCalculator.dispose();
                new WindowCalculator(new ConnectToTheClient());
            }
        });

        connectCore.add(connectServer);
        connectCore.add(connectClient);

        return connectCore;
    }
}

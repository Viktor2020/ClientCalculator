package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control;

import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectCore;
import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectionToTheServer;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.WindowStatistics;
import statistic.Statistic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by on 27.12.2014.
 */
public class StatisticActionListener implements ActionListener {

    private ConnectCore connectCore;

    public StatisticActionListener(ConnectCore connectCore) {
        this.connectCore = connectCore;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new WindowStatistics((Statistic)connectCore.getStatistic());
            }
        }).start();
    }
}

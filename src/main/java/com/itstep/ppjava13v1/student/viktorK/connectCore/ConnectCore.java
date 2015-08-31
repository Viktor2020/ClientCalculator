package com.itstep.ppjava13v1.student.viktorK.connectCore;

import statistic.Statistic;

import java.net.Socket;

/**
 * Created by on 14.01.2015.
 *
 * @author Viktor
 */
public interface ConnectCore {

    public String send(String statement);
//    public String send(String statement, Socket socket);
    public Statistic getStatistic();


}

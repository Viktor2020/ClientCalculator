package com.itstep.ppjava13v1.student.viktorK.connectCore;

import java.net.Socket;

/**
 * Created by on 15.01.2015.
 *
 * @author Viktor
 */
public interface ConnectServer {
    public Socket getSocket();
    public void setSocket(Socket socket);

}

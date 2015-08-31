package com.itstep.ppjava13v1.student.viktorK.connectCore;


import statistic.Statistic;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * Created by on 15.12.2014.
 * Sending messages to the server and receiving a response.
 */
public class ConnectionToTheServer implements ConnectCore , ConnectServer{
    /**
     * Connection to the server.
     */
    private Socket socket;

    private static final int DEFAULT_PORT = 3128;
    private static final String DEFAULT_HOST = "localhost";
    private int TIMEOUT_CONNECT_SERVER = 5000;


    /**
     * Sending messages to the server.
     *
     * @param statement messages.
     * @return server response.
     */
    public String send(String statement) {

        String answer = "";

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            if (socket == null) {
                socket = new Socket(DEFAULT_HOST, DEFAULT_PORT);
            }
            socket.setSoTimeout(TIMEOUT_CONNECT_SERVER);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            outputStream.write(statement.getBytes());
            outputStream.flush();
            socket.shutdownOutput();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            answer = bufferedReader.readLine()+ "\n";
            while (bufferedReader.ready()) {
                answer += bufferedReader.readLine() + "\n";
            }

        } catch (SocketTimeoutException e) {
            System.err.println("Timeout connection to the server(время ожидания ответа от сервера истекло)");
//            e.printStackTrace();
        } catch (java.net.ConnectException e) {
            System.err.println("No connection to the server (нет подключения к серверу)");
//            e.printStackTrace();
        } catch (SocketException e) {
            System.err.println("Lost connection to the server (потеряна связь с сервером)");
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return String.valueOf(answer);
    }

    /**
     * Sending messages to the server.
     *
     * @param statement messages.
     * @param socket    connection to the server or null if you want to set as default.
     * @return server response.
     */
    public String send(String statement, Socket socket) {
        this.socket = socket;
        return send(statement);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Get the response time from the server.
     *
     * @return waiting for the response from the server.
     */
    public int getTimeoutConnectServer() {
        return TIMEOUT_CONNECT_SERVER;
    }

    /**
     * Set the response time from the server.
     *
     * @param timeoutConnectServer waiting for the response from the server.
     */
    public void setTimeoutConnectServer(int timeoutConnectServer) {
        TIMEOUT_CONNECT_SERVER = timeoutConnectServer;
    }

    public Statistic getStatistic() {
        String statement = "STATISTIC";
        Statistic answer = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ObjectInputStream objectInputStream;
        try {
            if (socket == null) {
                socket = new Socket(DEFAULT_HOST, DEFAULT_PORT);
            }
            socket.setSoTimeout(TIMEOUT_CONNECT_SERVER);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            outputStream.write(statement.getBytes());
            outputStream.flush();
            socket.shutdownOutput();

            objectInputStream = new ObjectInputStream(inputStream);

            answer = (Statistic)objectInputStream.readObject();


        } catch (SocketTimeoutException e) {
            System.err.println("Timeout connection to the server(время ожидания ответа от сервера истекло)");
//            e.printStackTrace();
        } catch (java.net.ConnectException e) {
            System.err.println("No connection to the server (нет подключения к серверу)");
//            e.printStackTrace();
        } catch (SocketException e) {
            System.err.println("Lost connection to the server (потеряна связь с сервером)");
//            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return answer;
    }
}

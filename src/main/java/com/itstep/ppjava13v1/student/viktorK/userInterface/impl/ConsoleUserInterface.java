package com.itstep.ppjava13v1.student.viktorK.userInterface.impl;

import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectionToTheServer;
import com.itstep.ppjava13v1.student.viktorK.userInterface.UserInterface;
import statistic.Statistic;

import java.util.Scanner;

/**
 * Created by on 15.12.2014.
 */
public class ConsoleUserInterface implements UserInterface {

    private Scanner scanner = new Scanner(System.in);

    private Statistic statisticServer;

    @Override
    public void launch() {
        String expression;
        System.out.println("Добро пожаловать в клиент калькулятора , введите 'exitt' или 'q' для выхода");
        do {
            System.out.println("Введите математическое выражение ");
            expression = scanner.next();
            if (expression.equals("exitt") || expression.equals("q")) return;
            System.out.println(new ConnectionToTheServer().send(expression));
        } while (true);
    }
}

package com.itstep.ppjava13v1.student.viktorK;

import com.itstep.ppjava13v1.student.viktorK.userInterface.UserInterface;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.ConsoleUserInterface;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.WindowUserInterface;

/**
 * Created by on 14.12.2014.
 */
public class Main {

    public static void main(String[] args) {

        UserInterface userInterface = new WindowUserInterface();
        userInterface.launch();

    }

}

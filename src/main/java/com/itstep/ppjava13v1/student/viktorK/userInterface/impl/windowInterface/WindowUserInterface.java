package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface;

import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectCore;
import com.itstep.ppjava13v1.student.viktorK.connectCore.ConnectionToTheServer;
import com.itstep.ppjava13v1.student.viktorK.userInterface.UserInterface;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.control.*;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.menu.*;
import com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface.menu.MenuBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by on 15.12.2014.
 */
public class WindowUserInterface implements UserInterface {
    @Override
    public void launch() {

        new WindowCalculator(null);

    }
}

package com.itstep.ppjava13v1.student.viktorK.connectCore;

import com.itstep.ppjava13v1.student.viktorK.core.MathCal;
import statistic.Statistic;


/**
 * Created by on 14.01.2015.
 *
 * @author Viktor
 */
public class ConnectToTheClient implements ConnectCore {


    @Override
    public String send(String statement) {

        StringBuffer stringBuffer = new StringBuffer(statement);

        return String.valueOf(MathCal.eval(stringBuffer));
    }

    @Override
    public Statistic getStatistic() {
        return null;
    }
}

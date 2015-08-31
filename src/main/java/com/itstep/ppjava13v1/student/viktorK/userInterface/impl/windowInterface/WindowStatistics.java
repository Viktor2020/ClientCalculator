package com.itstep.ppjava13v1.student.viktorK.userInterface.impl.windowInterface;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import statistic.GregorianCalendarToString;
import statistic.Statistic;

import javax.swing.*;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Created by on 13.01.2015.
 *
 * @author Viktor
 */
public class WindowStatistics extends JFrame {
    public WindowStatistics(Statistic statistic) {

        setTitle("Статистика"); //заголовок вікна
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //створюємо діаграму
        final JFreeChart chart = ChartFactory.createLineChart(
                "Statistics", //Заголовок діаграми
                "Date",  //назва осі X
                "Count",  //назва осі Y
                getData(statistic), //дані
                PlotOrientation.VERTICAL, //орієнтація
                true, // включити легенду
                true, //підказки
                false // urls
        );

        //створюємо панель для графіка
        final ChartPanel chartPanel = new ChartPanel(chart);
        //встановлюємо розмір діаграми (можна також скористатись методами JFreeChart цього)
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        //додаємо панель на створений нами фрейм
        setContentPane(chartPanel);
        //підганяємо розміри фрейму
        pack();
        //робимо усе видимим
        setVisible(true);

    }

    private DefaultCategoryDataset getData(Statistic statistic) {
        if (statistic == null) statistic = new Statistic();
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        for (Map.Entry<GregorianCalendar, Double> map : statistic.getCountedOfExpressionsMap().entrySet()) {
            data.addValue(map.getValue(), "CountedOfExpressions", GregorianCalendarToString.convert(map.getKey()));
        }
        for (Map.Entry<GregorianCalendar, Double> map : statistic.getNumberOfSyntacticallyIncorrectExpressionMap().entrySet()) {
            data.addValue(map.getValue(), "NumberOfSyntacticallyIncorrectExpression", GregorianCalendarToString.convert(map.getKey()));
        }
        for (Map.Entry<GregorianCalendar, Double> map : statistic.getCacheUsageStatisticsMap().entrySet()) {
            data.addValue(map.getValue(), "CacheUsageStatistics", GregorianCalendarToString.convert(map.getKey()));
        }

        return data;
    }
}

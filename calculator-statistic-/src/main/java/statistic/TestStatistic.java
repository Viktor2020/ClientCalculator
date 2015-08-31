package statistic;

import java.util.GregorianCalendar;

/**
 * Created by on 13.01.2015.
 *
 * @author Viktor
 */
public class TestStatistic {
    public static void main(String[] args) {
        Statistic statistic = ReadStatistic.read();
        System.out.println(statistic);
        statistic.getCountedOfExpressionsMap().put(new GregorianCalendar(2015, 0, 12), 1.0);
        statistic.getCacheUsageStatisticsMap().put(new GregorianCalendar(2015, 0, 12), 2.0);
        statistic.getNumberOfSyntacticallyIncorrectExpressionMap().put(new GregorianCalendar(2015, 0, 10), 8.0);
        statistic.incrementCountedOfExpressions();
        statistic.incrementCountedOfExpressions();
        statistic.incrementCacheUsageStatistics();
        statistic.incrementCacheUsageStatistics();
        statistic.incrementCacheUsageStatistics();
        statistic.incrementCacheUsageStatistics();

        statistic.incrementNumberOfSyntacticallyIncorrectExpression();
        statistic.incrementNumberOfSyntacticallyIncorrectExpression();
        System.out.println(statistic);
        WriterStatistic.write(statistic);
    }
}

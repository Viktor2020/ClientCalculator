package statistic;

import java.io.Serializable;
import java.util.*;

/**
 * Created by on 27.12.2014.
 *
 * Реализовать фичу вывода статистики о работе сервера клиенту по запросу:
 * 1 количество подсчитанных выражений,
 * 2 количество синтаксически неверных выражений,
 * 3 статистика использования кэша.
 */
public class Statistic implements Serializable {

    /**
     * Counted the number of expressions.
     */
    private Map<GregorianCalendar, Double> countedOfExpressionsMap;// количество подсчитанных выражений

    /**
     * Number of syntactically incorrect expression.
     */
    private Map<GregorianCalendar, Double> numberOfSyntacticallyIncorrectExpressionMap;//количество синтаксически неверных выражений

    /**
     * Cache usage statistics.
     */
    private Map<GregorianCalendar, Double> cacheUsageStatisticsMap;//статистика использования кэша

    public Statistic() {
        countedOfExpressionsMap = new TreeMap<>(new CalendarComparator());
        numberOfSyntacticallyIncorrectExpressionMap = new TreeMap<>(new CalendarComparator());
        cacheUsageStatisticsMap = new TreeMap<>(new CalendarComparator());
    }

    /**
     * Increase in the number of counted expressions.
     */
    public void incrementCountedOfExpressions() {
        Double temp = countedOfExpressionsMap.get(new GregorianCalendar());
        if (temp != null) {
            countedOfExpressionsMap.replace(new GregorianCalendar(), (++temp));
        } else {
            countedOfExpressionsMap.put(new GregorianCalendar(), 1.0);
        }
    }

    /**
     * Increasing the number of syntactically incorrect expression.
     */
    public void incrementNumberOfSyntacticallyIncorrectExpression() {
        Double temp = numberOfSyntacticallyIncorrectExpressionMap.get(new GregorianCalendar());
        if (temp != null) {
            numberOfSyntacticallyIncorrectExpressionMap.replace(new GregorianCalendar(), (++temp));
        } else {
            numberOfSyntacticallyIncorrectExpressionMap.put(new GregorianCalendar(), 1.0);
        }
    }

    /**
     * Increasing the number of cache utilization.
     */
    public void incrementCacheUsageStatistics() {
        Double temp = cacheUsageStatisticsMap.get(new GregorianCalendar());
        if (temp != null) {
            cacheUsageStatisticsMap.replace(new GregorianCalendar(), (++temp));
        } else {
            cacheUsageStatisticsMap.put(new GregorianCalendar(), 1.0);
        }
    }

    /**
     * Get statistics on the number of counted expressions.
     *
     * @return countedOfExpressionsMap.
     */
    public Map<GregorianCalendar, Double> getCountedOfExpressionsMap() {
        return countedOfExpressionsMap;
    }

    /**
     * Get statistics on how many syntactically incorrect expression.
     *
     * @return numberOfSyntacticallyIncorrectExpressionMap.
     */
    public Map<GregorianCalendar, Double> getNumberOfSyntacticallyIncorrectExpressionMap() {
        return numberOfSyntacticallyIncorrectExpressionMap;
    }

    /**
     * Get cache usage statistics.
     *
     * @return cacheUsageStatisticsMap.
     */
    public Map<GregorianCalendar, Double> getCacheUsageStatisticsMap() {
        return cacheUsageStatisticsMap;
    }

    @Override
    public String toString() {
        return getCountedOfExpressionsMap() + "\n" +
                getNumberOfSyntacticallyIncorrectExpressionMap() + "\n" +
                getCacheUsageStatisticsMap() + "\n" ;
    }

    /**
     * Comparator for MAP with calendar
     */
    class CalendarComparator implements Comparator<Calendar>, Serializable {

        @Override
        public int compare(Calendar x, Calendar y) {

            int yearX = x.get(Calendar.YEAR);
            int monthX = x.get(Calendar.MONTH);
            int dayX = x.get(Calendar.DAY_OF_MONTH);

            int yearY = y.get(Calendar.YEAR);
            int monthY = y.get(Calendar.MONTH);
            int dayY = y.get(Calendar.DAY_OF_MONTH);

            if (yearX > yearY) return 1;
            if (monthX > monthY) return 1;
            if (dayX > dayY) return 1;

            if (yearX < yearY) return -1;
            if (monthX < monthY) return -1;
            if (dayX < dayY) return -1;

            return 0;
        }
    }

}





package statistic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by on 13.01.2015.
 * @author Viktor
 */
public class ReadStatistic {

    public static Statistic read(String pathAndFileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pathAndFileName)));
            Statistic obj = (Statistic) ois.readObject();
            ois.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Default read to path file statistics.stat
     * @return Statistics or null if statistics.stat not found.
     */
    public static Statistic read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("statistics.stat")));
            Statistic obj = (Statistic) ois.readObject();
            ois.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package statistic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by on 26.12.2014.
 */
public class WriterStatistic {

    public static void write(Statistic statistic) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("statistics.stat")));;
            oos.writeObject(statistic);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void write(String pathAndFileName, Statistic statistic) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pathAndFileName)));
            oos.writeObject(statistic);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

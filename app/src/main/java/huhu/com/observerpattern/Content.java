package huhu.com.observerpattern;

/**
 * Created by Huhu on 11/9/15.
 */
public class Content {
    private static int times = 0;

    public static void setTimes(int times) {
        Content.times = times;
    }

    public int getTimes() {
        return times;
    }

}
package huhu.com.observerpattern;

/**
 * Created by Huhu on 11/9/15.
 */
public class ConcreteWatcher implements Watcher {
    public String name = "";
    public String word = "";

    // 并覆写其方法
    @Override
    public void updateNotify(Content content) {
        // TODO Auto-generated method stub
        int times = content.getTimes();
        word = (name + "被投食" + times + "次");
    }
}
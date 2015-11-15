package huhu.com.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huhu on 11/9/15.
 */
public class ConcreteWatched implements Watched {
    // 定义一个List来聚集所有Watcher
    private List<Watcher> list = new ArrayList<Watcher>();

    /**
     * 增加一个观察者
     *
     * @param watcher
     */
    @Override
    public void add(Watcher watcher) {
        list.add(watcher);
    }

    /**
     * 删除一个观察者
     *
     * @param watcher
     */
    @Override
    public void remove(Watcher watcher) {
        list.remove(watcher);
    }

    /**
     * 通知所有观察者
     *
     * @param content
     */
    @Override
    public void notifyWatcher(Content content) {
        for (Watcher watcher : list) {
            watcher.updateNotify(content);
        }
    }
}
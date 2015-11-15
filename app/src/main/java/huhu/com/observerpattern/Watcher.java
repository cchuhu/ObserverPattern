package huhu.com.observerpattern;

/**
 * Created by Huhu on 11/9/15.
 */
public interface Watcher {
    //再定义一个用来获取更新信息接收的方法
    void updateNotify(Content content);

}
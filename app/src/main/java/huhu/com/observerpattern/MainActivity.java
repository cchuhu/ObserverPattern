package huhu.com.observerpattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    public Button btn_notify;
    public Button btn_escape;
    public Button btn_catch;
    Content content = new Content();
    TextView tv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化组件对象
        tv = (TextView) findViewById(R.id.tv);
        btn_notify = (Button) findViewById(R.id.btn_notify);
        btn_escape = (Button) findViewById(R.id.btn_escape);
        btn_catch = (Button) findViewById(R.id.btn_catch);
        doTest();
    }

    public void doTest() {
        //实例化被观察者
        final ConcreteWatched watched = new ConcreteWatched();
        //实例化观察者——蚊子
        final ConcreteWatcher mosquitoe = new ConcreteWatcher();
        mosquitoe.name = "蚊子";
        //实例化观察者——绵羊
        final ConcreteWatcher sheep = new ConcreteWatcher();
        sheep.name = "绵羊";
        //实例化观察者——兔子
        final ConcreteWatcher rabbit = new ConcreteWatcher();
        rabbit.name = "兔子";
        //将观察者加入被观察者的列表中。
        watched.add(mosquitoe);
        watched.add(sheep);
        watched.add(rabbit);

        //投食口令
        btn_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当管理员开始投食，投食次数开始变化，通知观察者改变状态
                int times = content.getTimes();
                times++;
                content.setTimes(times);
                watched.notifyWatcher(content);
                //显示在TextView中
                tv.setText(mosquitoe.word + "\n" + sheep.word + "\n" + rabbit.word + "\n");
            }
        });
        //去掉一个观察者
        btn_escape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watched.remove(rabbit);
            }
        });
        //增加一个观察者
        btn_catch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watched.add(rabbit);
            }
        });
    }


}
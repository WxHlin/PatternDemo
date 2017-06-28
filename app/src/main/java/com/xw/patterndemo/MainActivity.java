package com.xw.patterndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xw.patterndemo.mydemo.User;
import com.xw.patterndemo.observerModel.Observable;
import com.xw.patterndemo.observerModel.Observer;
import com.xw.patterndemo.observerModel.Weather;

public class MainActivity extends AppCompatActivity {

    private Button tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (Button) findViewById(R.id.tv);

        //单例使用
        Singleton.getInstance().addActicity(MainActivity.this);

        //Build模式使用
        Person.Builder builder = new Person.Builder();
        Person person = builder.name("xxxxx")
                .age(25)
                .height(175.6)
                .weight(130.6)
                .build();
        Log.e("MainActivity","age"+person.getAge());

        //仿写
        User.Builder builder1=new User.Builder();
        User user=builder1.id("456123")
                .name("wwwwwww")
                .address("武汉")
                .build();
        Log.e("MainActivity","address"+user.getAddress());


        //观察者模式使用
        final Observable<Weather> observable=new Observable<Weather>();

        Observer<Weather> observer1=new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("MainActivity1："+data.toString());
            }
        };

        Observer<Weather> observer2=new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("MainActivity2："+data.toString());
            }
        };
        observable.register(observer1);
        observable.register(observer2);

        observable.unregister(observer1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weather weather=new Weather("晴转多云");
                observable.notifyObservers(weather);
            }
        });
    }
}

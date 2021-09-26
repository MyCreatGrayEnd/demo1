package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第一种  只要点击事件，不实例化
        findViewById(R.id.btn_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"我是按钮1",Toast.LENGTH_SHORT).show();
            }
        });
        //第二种  先实例化，然后添加监听事件
        Button btn_test2 = findViewById(R.id.btn_test2);
       // btn_test2.setOnClickListener(this);  也可以这样
        btn_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"我是按钮2",Toast.LENGTH_SHORT).show();
            }
        });

        //第四种 用黄油刀 Butter Knife  后期可用
        //第五种 用mvvm的双向绑定  后期可用
    }
    //第三种 在布局文件指定  点击事件方法名
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.btn_test3://此处是对布局中设置的id直接进行判断，
                // 不需要对控件进行获取（findviewByID）
                Toast.makeText(this, "我是按钮3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
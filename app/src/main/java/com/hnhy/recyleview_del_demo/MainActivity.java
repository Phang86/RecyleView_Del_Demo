package com.hnhy.recyleview_del_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hnhy.recyleview_del_demo.adapter.BaseRecyclerViewAdapter;
import com.hnhy.recyleview_del_demo.adapter.MsgAdapter;
import com.hnhy.recyleview_del_demo.bean.MsgBean;
import com.hnhy.recyleview_del_demo.view.SlideRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private SlideRecyclerView rv;
    private List<MsgBean> mData = new ArrayList<>();
    private MsgAdapter adapter;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rv = findViewById(R.id.main_rv);
        adapter = new MsgAdapter(this, mData);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String nowTime = sdf.format(new Date());

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                mData.add(new MsgBean(nowTime,"系统消息告知最近系统消息告知最近系统消息告知最近系统消息告知最近",i));
            }else{
                mData.add(new MsgBean(nowTime,"哈哈哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈",i));
            }
        }
        setListener();
    }

    private void setListener() {
        adapter.setOnDeleteClickLister(new MsgAdapter.OnDeleteClickLister() {
            @Override
            public void onDeleteClick(View view, int position) {
                Log.e(TAG, "onDeleteClick: "+position);
            }
        });

    }

}
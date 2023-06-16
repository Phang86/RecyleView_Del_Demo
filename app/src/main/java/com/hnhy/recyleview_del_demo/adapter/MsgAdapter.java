package com.hnhy.recyleview_del_demo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hnhy.recyleview_del_demo.R;
import com.hnhy.recyleview_del_demo.bean.MsgBean;

import java.util.List;

public class MsgAdapter extends BaseRecyclerViewAdapter<MsgBean>{

    private OnDeleteClickLister onDeleteClickLister;

    public MsgAdapter(Context context, List<MsgBean> data) {
        super(context, data, R.layout.item_delete);
    }

    @Override
    protected void onBindData(RecyclerViewHolder holder, MsgBean bean, int position) {
        ((TextView) holder.getView(R.id.item_tv_msg_title)).setText(bean.getTitle());
        ((TextView) holder.getView(R.id.item_tv_test_msg_time)).setText(bean.getTime());
        ((TextView) holder.getView(R.id.item_tv_test_msg_info)).setText(bean.getMsgInfo());
        ((TextView) holder.getView(R.id.item_tv_msg_flag)).setVisibility(bean.getFlag() == 0 ? View.GONE : View.VISIBLE);
        View view = holder.getView(R.id.item_tv_delete);
        view.setTag(position);
        if (!view.hasOnClickListeners()) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onDeleteClickLister.onDeleteClick(view, (Integer) view.getTag());
                }
            });
        }
    }

    public void setOnDeleteClickLister(OnDeleteClickLister onDeleteClickLister) {
        this.onDeleteClickLister = onDeleteClickLister;
    }

    public interface OnDeleteClickLister{
        void onDeleteClick(View view, int position);
    }
}

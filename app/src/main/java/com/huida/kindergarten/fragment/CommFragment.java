package com.huida.kindergarten.fragment;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.huida.kindergarten.adapter.ContactAdapter;
import com.huida.kindergarten.R;
import com.huida.kindergarten.base.BaseFragment;
import com.huida.kindergarten.bean.ContactMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scout
 * Created on 2017/10/24 14:03.
 */
public class CommFragment extends BaseFragment {

    public Toolbar mToolbar;

    @Override
    protected int getContentView() {
        return R.layout.fragment_comm;
    }

    @Override
    protected void initViews(View view) {
        final RecyclerView rvMessage = view.findViewById(R.id.id_comm_rv_messages);
        rvMessage.setLayoutManager(new LinearLayoutManager(mActivity,
                LinearLayoutManager.VERTICAL, false));
        List<ContactMessage> datas = getData();
        rvMessage.setAdapter(new ContactAdapter(mActivity, datas));

        initToolbar(view);
    }

    private void initToolbar(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.id_main_toolbar);
        final TextView title = mToolbar.findViewById(R.id.id_toolbar_title);
        title.setText("沟通");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }

    @Override
    protected void initListeners() {

    }

    public List<ContactMessage> getData() {
        final List<ContactMessage> datas = new ArrayList<>();
        datas.add(new ContactMessage("中三班", "谁有赵老师电话", "", "2017-9-02"));
        datas.add(new ContactMessage("卡卡妈妈", "我有一只小毛驴，老师你造么", "", "2017-9-02"));
        datas.add(new ContactMessage("靖爸爸", "我也有一只小毛驴，老师你造么", "", "2017-9-02"));
        return datas;
    }
}

package com.huida.kindergarten.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.huida.kindergarten.R;
import com.huida.kindergarten.base.BaseFragment;
import com.huida.kindergarten.view.XCRoundRectImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 81521 on 2017/10/24.
 * 班级Fragment
 */

public class ClassFragment extends BaseFragment {

    private ImageButton mIbClassMsg;
    private XCRoundRectImageView mIvHead;
    private TextView mTvBabyName;
    private TextView mTvBabyClass;
    private RecyclerView mRvMoudle;
    private RecyclerView mRvRanking;
    private RecyclerView mRvShuoshuo;

    String[] names = {"园所通知","园所缴费","视频观看","园所食谱","宝宝出勤","亲子作业","班级相册","教学计划"};
    int icons[] = {R.mipmap.home_notice,R.mipmap.home_payment,R.mipmap.home_video,R.mipmap.home_cook
            ,R.mipmap.home_kq,R.mipmap.home_homework,R.mipmap.home_album,R.mipmap.home_teachplan};

    @Override
    protected int getContentView() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initViews(View view) {
        mRvMoudle = view.findViewById(R.id.rv_moudle);
        mIbClassMsg = view.findViewById(R.id.ib_class_msg);
        mIvHead = view.findViewById(R.id.iv_head);
        mTvBabyName = view.findViewById(R.id.tv_baby_name);
        mTvBabyClass = view.findViewById(R.id.tv_baby_class);
        mRvMoudle = view.findViewById(R.id.rv_moudle);
        mRvRanking = view.findViewById(R.id.rv_ranking);
        mRvShuoshuo = view.findViewById(R.id.rv_shuoshuo);
        initMoudles();
    }

    private void initMoudles() {
        mRvMoudle.setLayoutManager(new GridLayoutManager(mActivity,4));
        mRvMoudle.setAdapter(new ClassMoudleAdapter());


    }

    @Override
    protected void initListeners() {

    }

    /**
     * 八大模块的适配器
     */
    class ClassMoudleAdapter extends RecyclerView.Adapter<ClassMoudleAdapter.ClassMoudleViewHolder>{
        @Override
        public ClassMoudleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_class_moudle, parent, false);
            return new ClassMoudleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ClassMoudleViewHolder holder, final int position) {
            holder.iv_icon.setImageResource(icons[position]);
            holder.tv_name.setText(names[position]);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击事件
                    onMoudleItemClick(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        class ClassMoudleViewHolder extends RecyclerView.ViewHolder{
            ImageView iv_icon;
            TextView tv_name;
            public ClassMoudleViewHolder(View itemView) {
                super(itemView);
                iv_icon = itemView.findViewById(R.id.class_item_icon);
                tv_name = itemView.findViewById(R.id.class_item_name);
            }
        }
    }

    /**
     * 模块的条目点击事件
     * @param position
     */
    private void onMoudleItemClick(int position) {
        switch (position){
            case 0://园所通知
                break;
            case 1://园所缴费
                break;
            case 2://视频观看
                break;
            case 3://园所食谱
                break;
            case 4://宝宝出勤
                break;
            case 5://亲子作业
                break;
            case 6://班级相册
                break;
            case 7://教学计划
                break;
        }
    }
}

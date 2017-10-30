package com.huida.kindergarten.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.huida.kindergarten.R;
import com.huida.kindergarten.adapter.NineLayoutAdapter;
import com.huida.kindergarten.base.BaseFragment;
import com.huida.kindergarten.view.imageview.CircleImageView;
import com.huida.kindergarten.view.FullyGridLayoutManager;
import com.huida.kindergarten.view.FullyLinearLayoutManager;
import com.huida.kindergarten.view.XCRoundRectImageView;
import com.w4lle.library.NineGridlayout;

import java.util.ArrayList;

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

    private String[] names = {"园所通知","园所缴费","视频观看","园所食谱","宝宝出勤","亲子作业","班级相册","教学计划"};
    private int icons[] = {R.mipmap.home_notice,R.mipmap.home_payment,R.mipmap.home_video,R.mipmap.home_cook
            ,R.mipmap.home_kq,R.mipmap.home_homework,R.mipmap.home_album,R.mipmap.home_teachplan};
    private ArrayList<String> tempImageList;

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

        initData();

    }

    private void initData() {
        //初始化导航
        initMoudles();
        //初始化宝宝星星排名
        initRanking();
        //初始化说说
        initShuoShuo();
    }

    private void initShuoShuo() {
        //模拟数据，说说的图片
        tempImageList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            tempImageList.add("http://www.chinaplat.com/IMGZT/img-20170907/20170907164491819181.png");
        }
        mRvShuoshuo.setLayoutManager(new FullyLinearLayoutManager(mActivity));
        mRvShuoshuo.setAdapter(new ShuoshuoAdapter());
    }

    private void initRanking() {
        mRvRanking.setLayoutManager(new FullyGridLayoutManager(mActivity,4));
        mRvRanking.setAdapter(new RankingAdapter());
    }


    private void initMoudles() {
        mRvMoudle.setLayoutManager(new FullyGridLayoutManager(mActivity,4));
        mRvMoudle.setAdapter(new ClassMoudleAdapter());
    }

    @Override
    protected void initListeners() {

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
     * 宝宝排名适配器
     */
    class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder>{
        @Override
        public RankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_class_ranking, parent, false);
            return new RankingViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RankingViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }

        class RankingViewHolder extends RecyclerView.ViewHolder{
            CircleImageView iv_head;
            ImageView iv_number;
            public RankingViewHolder(View itemView) {
                super(itemView);
                iv_head = itemView.findViewById(R.id.iv_ranking_head);
                iv_number = itemView.findViewById(R.id.iv_ranking_number);
            }
        }

    }

    /**
     * 说说的Adapter
     */
    class ShuoshuoAdapter extends  RecyclerView.Adapter<ShuoshuoAdapter.ShuoshuoViewAdapter>{

        @Override
        public ShuoshuoViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_class_shuoshuo, parent, false);
            return new ShuoshuoViewAdapter(view);
        }

        @Override
        public void onBindViewHolder(ShuoshuoViewAdapter holder, int position) {
            //头像
            holder.iv_icon.setImageResource(R.mipmap.temp_head);
            //名称
            holder.tv_name.setText("张雷老师");
            //时间
            holder.tv_time.setText("3分钟前");
            //内容
            holder.tv_content.setText("啊哈哈哈哈哈第十搜安定的四十年底哦哦我啊哈哈哈哈哈第十搜安定的四十年底哦哦我");
            //九宫格图片
            NineLayoutAdapter nineLayoutAdapter = new NineLayoutAdapter(mActivity, tempImageList);
            holder.nine_gv.setAdapter(nineLayoutAdapter);
            //评论
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        class  ShuoshuoViewAdapter extends RecyclerView.ViewHolder{
            CircleImageView iv_icon;
            TextView tv_name;
            TextView tv_time;
            TextView tv_content;
            NineGridlayout nine_gv;
            TextView tv_zan_count;
            TextView tv_comment_count;
            ImageView iv_zan;
            ImageView iv_comment;
            TextView tv_zan_names;
            ListView lv_comment_list;

            public ShuoshuoViewAdapter(View itemView) {
                super(itemView);
                 iv_icon = itemView.findViewById(R.id.iv_shuoshuo_icon);
                 tv_name = itemView.findViewById(R.id.tv_shuoshuo_name);
                 tv_time = itemView.findViewById(R.id.tv_shuoshuo_time);
                 tv_content = itemView.findViewById(R.id.tv_item_content);
                 nine_gv = itemView.findViewById(R.id.nine_gv);
                 tv_zan_count = itemView.findViewById(R.id.tv_zan_count);
                 tv_comment_count = itemView.findViewById(R.id.tv_comment_count);
                 iv_zan = itemView.findViewById(R.id.iv_zan);
                 iv_comment = itemView.findViewById(R.id.iv_comment);
                 tv_zan_names = itemView.findViewById(R.id.tv_zan_names);
                 lv_comment_list = itemView.findViewById(R.id.lv_comment_list);
            }
        }
    }

}

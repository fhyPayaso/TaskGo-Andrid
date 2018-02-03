package cn.abtion.taskgo.mvp.view.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import cn.abtion.taskgo.R;
import cn.abtion.taskgo.base.adapter.BaseRecyclerViewAdapter;
import cn.abtion.taskgo.mvp.model.request.home.BaseTaskModel;
import cn.abtion.taskgo.mvp.view.home.adapter.TaskListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author fhyPayaso
 * @since 2018/2/3 on 上午11:26
 * fhyPayaso@qq.com
 */
public class NoBtnTaskRecAdapter extends BaseRecyclerViewAdapter<BaseTaskModel> {


    private TaskListener mTaskListener;

    public NoBtnTaskRecAdapter(Context context, List<BaseTaskModel> baseTaskModels) {
        super(context, baseTaskModels);
    }

    @Override
    public BaseViewHolder<BaseTaskModel> onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_base_task, parent, false);
        return new ItemHolder(view);
    }

    public void setTaskListener(TaskListener listener) {
        mTaskListener = listener;
    }


    class ItemHolder extends BaseViewHolder<BaseTaskModel> implements View.OnClickListener {

        @BindView(R.id.img_avatar)
        CircleImageView mImgAvatar;
        @BindView(R.id.txt_username)
        TextView mTxtUsername;
        @BindView(R.id.txt_main_title)
        TextView mTxtMainTitle;
        @BindView(R.id.txt_main_title_value)
        TextView mTxtMainTitleValue;
        @BindView(R.id.txt_subtitle)
        TextView mTxtSubtitle;
        @BindView(R.id.txt_release_time)
        TextView mTxtReleaseTime;
        @BindView(R.id.btn_task)
        TextView mBtnTask;


        public ItemHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            mImgAvatar.setOnClickListener(this);
        }

        @Override
        protected void onBind(BaseTaskModel baseTaskModel, int position) {

            //必有部分
            mTxtUsername.setText(baseTaskModel.getUsername() == null ? "N/A" : baseTaskModel.getUsername());
            mTxtReleaseTime.setText(baseTaskModel.getReleaseTime() == null ? "N/A" : baseTaskModel.getReleaseTime());
            mTxtMainTitleValue.setText(baseTaskModel.getMainValue() == null ? "N/A" : baseTaskModel.getMainValue());

            //水任务添加附加信息
            if (baseTaskModel.getTaskType() == 0) {

                mTxtMainTitle.setText("宿舍号：");
                mTxtSubtitle.setText(baseTaskModel.getSubTitle() == null ? "N/A" : baseTaskModel.getSubTitle());
            } else {
                mTxtMainTitle.setText("物品名称：");
                mTxtSubtitle.setText("");
            }

            //设置按钮是否可见，可见则设置按钮内容
            mBtnTask.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.img_avatar) {
                mTaskListener.onClickAvatar(getAdapterPosition());
            }
        }
    }
}
package cn.abtion.taskgo.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.abtion.taskgo.base.contract.BaseContract;

/**
 * @author FanHongyu.
 * @since 18/1/17 00:39.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BaseNoBarPresenterActivity<Presenter extends BaseContract.Presenter> extends BaseNoBarActivity
        implements BaseContract.View<Presenter> {

    protected Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //创建时就绑定P层
        initPresenter();
        super.onCreate(savedInstanceState);
    }

    /**
     * V层创建 与之绑定的P层对象
     *
     * @return 与之绑定的P层对象
     */
    protected abstract Presenter initPresenter();

    @Override
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}

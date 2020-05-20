package com.penner.architecture.view.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;

import com.penner.architecture.presenter.MvpPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by penneryu on 16/8/29.
 */
public class SwipeRefreshLayoutDataBinding {

    @BindingAdapter("android:onRefresh")
    public static void setSwipeRefreshLayoutOnRefreshListener(SmartRefreshLayout view, final MvpPresenter presenter) {
        view.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.loadDatas();

            }

        });
    }
}

package com.penner.architecture;

import android.app.Application;
import android.content.Context;

import com.penner.architecture.util.TimeUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Created by penneryu on 16/8/5.
 */
public class PennerApplication extends Application {

    public static Context sContext;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .domainDaggerModel(new DomainDaggerModel())
                .build();

        initSmartRefreshLayout();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


    private void initSmartRefreshLayout() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate).setTimeFormat(TimeUtil.FMT).setPrimaryColorId(R.color.colorPrimary));
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate));
    }
}

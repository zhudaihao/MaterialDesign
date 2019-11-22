package cn.zdh.materialdesign.md;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import cn.zdh.materialdesign.R;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        init();

    }

    private void init() {
        /**
         * Toolbar设置
         */
        final Toolbar toolbar = findViewById(R.id.toolbar);
        //设置沉浸式状态栏
//        StatusBarUtils.setTranslucentImageHeader(this,0,toolbar);


        /**
         * collapsingToolbarLayout设置
         */
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing);
        //设置title最后颜色
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        //设置title初始颜色
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        //设置纱布 可以设置颜色 或者图片
        collapsingToolbarLayout.setContentScrim(getDrawable(R.color.colorPrimaryDark));


        /**
         * AppbarLayout设置
         */
        AppBarLayout appBarLayout = findViewById(R.id.appbar_layout);
        //监听appbarLayout 的偏移
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                //获取总滚动的范围
                Log.e("zdh", "-------------i  " + i + "----------appBarLayout.getTotalScrollRange()" + appBarLayout.getTotalScrollRange());
                if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {


//                    toolbar.setTitleMarginStart(toolbar.getWidth()/2);
//                    toolbar.setTitleMarginEnd(toolbar.getWidth()/2-100);
                } else {

                }


            }
        });

    }


}

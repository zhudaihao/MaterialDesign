package cn.zdh.materialdesign.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.zdh.materialdesign.R;

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        tabLayout = findViewById(R.id.tabLayout);

        //监听
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中的item  回调
                Log.e("zdh","------------onTabSelected"+tab.getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //当前这个选中 点击下一个，当前这个item回调
                Log.e("zdh","------------onTabUnselected"+tab.getText().toString());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //如果item选中了再点击这个item 回调这个方法
                Log.e("zdh","------------onTabReselected"+tab.getText().toString());
            }
        });

    }


}

package cn.zdh.materialdesign.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.zdh.materialdesign.R;

/**
 * 自定义CoordinatorLayout和Behavior
 */
public class LinearActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_linear);
    }
}

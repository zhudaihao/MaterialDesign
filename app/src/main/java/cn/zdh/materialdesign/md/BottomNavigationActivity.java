package cn.zdh.materialdesign.md;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import cn.zdh.materialdesign.R;

public class BottomNavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navi);

        BottomNavigationView bnv=findViewById(R.id.bnv);

        /***
         * 如果你要 对item的图标文字 自己处理重新这个方法 ,不然就系统处理
         * 注意 返回true
         */
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //自定义
//                setCustom(menuItem);

                return false;

            }
        });

        /**
         * 点击item的监听
         */
        bnv.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                switch (itemId){
                    case R.id.item1:
                    Toast.makeText(BottomNavigationActivity.this, "点击menuItem1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item2:
                        Toast.makeText(BottomNavigationActivity.this, "点击menuItem2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item3:
                        Toast.makeText(BottomNavigationActivity.this, "点击menuItem3", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }

    private void setCustom(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        switch (itemId){
            case R.id.item1:
              menuItem.setIcon(R.mipmap.icon);
                break;
            case R.id.item2:
                menuItem.setIcon(R.mipmap.icon);
                break;
            case R.id.item3:
                menuItem.setIcon(R.mipmap.icon);
                break;
        }
    }
}

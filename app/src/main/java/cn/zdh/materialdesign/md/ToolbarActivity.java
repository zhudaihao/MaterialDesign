package cn.zdh.materialdesign.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cn.zdh.materialdesign.R;

public class ToolbarActivity extends AppCompatActivity {

   private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_toolbar);
        toolbar=findViewById(R.id.toolbar);

        init1();

    }

    private void init1() {
        //设置 menu
        toolbar.inflateMenu(R.menu.layout_toolbar_menu);

        //点击监听navigation
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("点击navigation");

            }
        });

        //监听menu
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.i1:
                        showToast("点击id i1");
                        break;
                    case R.id.i2:
                        showToast("点击id i2");
                        break;
                    case R.id.i3:
                        showToast("点击id i3");
                        break;
                    case R.id.i4:
                        showToast("点击id i4");
                        break;
                    case R.id.i5:
                        showToast("点击id i5");
                        break;
                }


                return true;
            }
        });
    }

    private void showToast(String content) {
        Toast.makeText(ToolbarActivity.this, content, Toast.LENGTH_SHORT).show();
    }
}

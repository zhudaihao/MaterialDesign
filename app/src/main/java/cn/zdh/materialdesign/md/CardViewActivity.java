package cn.zdh.materialdesign.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import cn.zdh.materialdesign.R;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class CardViewActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

        imageView = findViewById(R.id.iv);

        //加载图片
        Glide.with(this)
                .load(R.mipmap.tp)
                //剪切图片
                .bitmapTransform(new RoundedCornersTransformation(this, 8, 0, RoundedCornersTransformation.CornerType.ALL))
                .error(R.mipmap.tp)
                .into(imageView);

    }


}

package cn.zdh.materialdesign.custom;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义behavior 实现向下滑动隐藏title  向上滑动显示title
 */
public class CustomBehavior extends CoordinatorLayout.Behavior {

    private float tagHeight = 0;

    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof NestedScrollView;
    }



    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {

        //标记需要移动多少距离 title才显示完全
        if (tagHeight == 0) {
            tagHeight = dependency.getY() - child.getHeight();
        }

        //记录滑动变化Y
        float dy = dependency.getY() - child.getHeight();

        dy = dy < 0 ? 0 : dy;
        //比例系数
        float ratio = dy / tagHeight;

        /**
         * 平移动画
         */
        setTranslation(child, ratio);

        /**
         * 透明度动画
         *
         */
        setAlpha(child, ratio);


        return false;

    }

    private void setAlpha(@NonNull View child, float ratio) {
        if (ratio == 1.0) {
            //全透明
            child.setBackgroundColor(Color.argb(0, 249, 190, 24));
        } else if (ratio >= 0.5) {
            //变化透明度
            int alpha = (int) (255 / ratio);
            child.setBackgroundColor(Color.argb(alpha, 249, 190, 24));
        }
    }

    private void setTranslation(@NonNull View child, float ratio) {
        /**
         * 平移动画
         */
        //通过比例系数计算title显示距离 ;title在屏幕外所有负数
        float y = -ratio * child.getHeight();
        child.setTranslationY(y);
    }


}

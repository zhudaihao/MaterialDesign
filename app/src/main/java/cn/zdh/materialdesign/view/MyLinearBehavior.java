package cn.zdh.materialdesign.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


public class MyLinearBehavior {
    private Context context;

    public MyLinearBehavior(Context context) {
        this.context = context;
    }


    /**
     * 判断被观察者
     */

    public boolean layoutDependsOn(@NonNull View parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof NestedScrollView;
    }

    /**
     * 处理观察者 动画
     *
     * @param myLinearLayout 最外层view
     * @param child          观察者
     * @param dependView     被观察者
     * @param i              水平滚动距离，单位为目标已经消耗的像素
     * @param i1             垂直滚动距离，单位为目标已经消耗的像素  (nestedScrollView 向上滑动Y为正 向下滑动为负 滑出距离)
     * @param i2             没有被目标消耗的像素的水平滚动距离
     * @param i3             动态消耗垂直滚动距离，单位为目标未消耗的像素
     * @param i4             输入导致滚动事件的类型
     */

    public void onDependentViewChanged(MyLinearLayout myLinearLayout, View child, View dependView, int i, int i1, int i2, int i3, int i4) {
        if (i1 < 0) {
            //向下滑动动画
            if (child.getY() <= 0 && dependView.getY() <= child.getHeight()) {
//                Log.e("zdh", "-----------dependView.getY()--->" + dependView.getY());
                float dy=-(dependView.getScrollY() > child.getHeight() ? child.getHeight() : dependView.getScrollY());
                Log.e("zdh", "-----------向下dy=" + dy);
                child.setTranslationY(-(dependView.getScrollY() > child.getHeight() ? child.getHeight() : dependView.getScrollY()));
                dependView.setTranslationY(-(dependView.getScrollY() > child.getHeight() ? child.getHeight() : dependView.getScrollY()));
                //修改被观察者高度
//                ViewGroup.LayoutParams layoutParams = dependView.getLayoutParams();
//                layoutParams.height= (int) (myLinearLayout.getHeight()-child.getHeight()-child.getTranslationY());
//                dependView.setLayoutParams(layoutParams);


            }


        } else {
            //向上滑动动画
//            Log.e("zdh", "-----------dependView.getY()" + dependView.getY());
            if (dependView.getY() > 0) {
                float dy=-(dependView.getScrollY() > child.getHeight() ? child.getHeight() : dependView.getScrollY());
//                Log.e("zdh", "-----------向上dy=" + dy);

                //设置观察者（TextView）的Y坐标偏移 不能超过自己高度 (向上移动是负数)
                child.setTranslationY(-(dependView.getScrollY() > child.getHeight() ? child.getHeight() : dependView.getScrollY()));
                //设置被观察者（NestedScrollView）Y坐标偏移量 偏移量和child一致
                dependView.setTranslationY(-(dependView.getScrollY() > child.getHeight() ? child.getHeight() : dependView.getScrollY()));

                //获取被观察者的LayoutParams
                ViewGroup.LayoutParams layoutParams = dependView.getLayoutParams();
                //修改被观察者高度 ：被观察者高度=它父亲高度 减去观察者的高度  减去观察者偏移量Y
                layoutParams.height = (int) (myLinearLayout.getHeight() -child.getHeight() - child.getTranslationY());

                Log.e("zdh", "-----------child.getHeight()" + child.getHeight() + "----------child.getTranslationY()" + child.getTranslationY());
                //设置被观察者新的高度
                dependView.setLayoutParams(layoutParams);


            }

        }


    }


}

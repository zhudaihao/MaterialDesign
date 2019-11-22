package cn.zdh.materialdesign.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.view.NestedScrollingParent2;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.Constructor;

import cn.zdh.materialdesign.R;

/**
 * 自定义 CoordinatorLayout
 */
public class MyLinearLayout extends LinearLayout implements NestedScrollingParent2 {


    /**
     * LineaLayout
     */
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    /**
     * NestedScrollingParent2
     */
    @Override
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view1, int i, int i1) {

        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view1, int i, int i1) {

    }

    @Override
    public void onStopNestedScroll(@NonNull View view, int i) {

    }

    /**
     * 核心代码 NestedScrollView 的所有滑动事件 都会回调这个方法（上下滑动距离 惯性滑动距离）
     *
     * @param view
     * @param i    x的偏移量  左滑正  右滑负
     * @param i1   Y的偏移量  上滑正  下滑负
     * @param i2
     * @param i3
     * @param i4
     */
    @Override
    public void onNestedScroll(@NonNull View view, int i, int i1, int i2, int i3, int i4) {
//        Log.e("zdh", "-------view" + view.getClass().getName()
//                + "------i"
//                + i + "-----i1"
//                + i1 + "-------i2"
//                + i2 + "---------i3"
//                + i3 + "---------i4" + i4);


        //获取子类个数
        int childCount = this.getChildCount();
        //遍历子类
        for (int i5 = 0; i5 < childCount; i5++) {
            //获取子类
            View childAt = this.getChildAt(i5);
            //获取子类属性类
            MyLinearLayoutParams layoutParams = (MyLinearLayoutParams) childAt.getLayoutParams();
            //调用自定义布局参数
            MyLinearBehavior myLinearBehavior = layoutParams.myLinearBehavior;
            //再把滑动事件传递给Behavior对应方法
            if (myLinearBehavior != null) {
                //调用 MyLinearBehavior判断被观察者的方法
                if (myLinearBehavior.layoutDependsOn(this, childAt, view)) {
                    //调用观察者改变动作的方法
                    myLinearBehavior.onDependentViewChanged(this, childAt, view, i, i1, i2, i3, i4);
                }
            }


        }

    }


    /**
     * 这个方法就是定义当前这个view 下所有的子view布局使用LayoutParam类
     * 注意参数是AttributeSet
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MyLinearLayoutParams(getContext(), attrs);
    }

    /**
     * 自定义布局参数
     */
    private class MyLinearLayoutParams extends LayoutParams {
        //自定义属性参数
        private MyLinearBehavior myLinearBehavior;

        public MyLinearLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            //把自定义属性 交给TypedArray 管理
            TypedArray array = c.obtainStyledAttributes(attrs, R.styleable.MyLinearLayout);
            //获取自定义属性值--》MyLinearBehavior全类名
            String className = array.getString(R.styleable.MyLinearLayout_layout_behavior);
            //反射创建MyLinearBehavior实例
            try {
                myLinearBehavior = getBehavior(c, attrs, className);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            //注意 最后要释放资源
            array.recycle();


        }


        /**
         * 反射获取 behavior实例
         *
         * @param className 全类名
         * @return
         * @throws NoSuchMethodException
         */
        private MyLinearBehavior getBehavior(Context c, AttributeSet attrs, String className) throws NoSuchMethodException {
            MyLinearBehavior behavior = null;
            //非空判断
            if (TextUtils.isEmpty(className)) {
                return null;
            }
            try {
                //通过全类名获取class对象
                Class aClass = Class.forName(className);
                //判断aClass类是否是MyLinearBehavior 的类或者接口
                if (!MyLinearBehavior.class.isAssignableFrom(aClass)) {
                    return null;
                }
                //获取化构造方法
                Constructor<? extends MyLinearBehavior> constructor = aClass.getConstructor(Context.class);
                //权限
                constructor.setAccessible(true);
                //获取实例
                behavior = constructor.newInstance(c);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return behavior;
        }


    }


    @Override
    public void onNestedPreScroll(@NonNull View view, int i, int i1, @NonNull int[] ints, int i2) {

    }


}

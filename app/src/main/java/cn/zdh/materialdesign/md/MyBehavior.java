package cn.zdh.materialdesign.md;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * 自定义 Behavior  T是观察者--》触发事件后作出响应的view
 */
public class MyBehavior extends CoordinatorLayout.Behavior<TextView> {
    boolean isOne = true;


    /**
     * 注意一定要写构造方法
     * 在xml中设置      需要写双参构造方法
     * 在Java代码中设置  需要无参构造方法
     */

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 用来确定本次交互行为中的 dependent View
     * <p>
     * 返回true表示 交互对象匹配了，false表示交互对象不匹配
     * <p>
     * 直白点 -->确认 被观察者对象
     *
     * @param parent
     * @param child      观察者
     * @param dependency 被观察者
     * @return
     */

    @Override
    public boolean layoutDependsOn( CoordinatorLayout parent,  TextView child,  View dependency) {
//        return super.layoutDependsOn(parent, child, dependency);
        Log.e(TAG, "----------dependency "+dependency.getClass().getName());
        return dependency instanceof Button;
    }

    /**
     * 处理 观察者作出响应的动作的代码
     *
     * @param parent
     * @param child      观察者
     * @param dependency 被观察者
     * @return
     */
    @Override
    public boolean onDependentViewChanged( CoordinatorLayout parent,  TextView child,  View dependency) {
        if (!isOne) {
            child.setX(dependency.getX() + child.getWidth());
            child.setY(dependency.getY() + child.getHeight());

        }
        isOne = false;

        return true;

    }
}

package cn.zdh.materialdesign.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.zdh.materialdesign.R;

/**
 * MD常用控件使用
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "zdh";
    private Button button;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }




    private void init() {
        button = findViewById(R.id.bt);
        textView = findViewById(R.id.tv);




        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX()-v.getWidth()/2);
                    v.setY(event.getRawY()-v.getHeight());
                }


//                Log.e(TAG,"----------getRawY "+event.getRawY()+"--------------getY  "+event.getY());

                Log.e(TAG, "--------------getY  " + v.getY());
                return true;
            }
        });


    }


}

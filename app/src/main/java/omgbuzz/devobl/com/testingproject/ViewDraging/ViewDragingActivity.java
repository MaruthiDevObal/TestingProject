package omgbuzz.devobl.com.testingproject.ViewDraging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import omgbuzz.devobl.com.testingproject.R;

public class ViewDragingActivity extends AppCompatActivity {

    ImageView text;
    int xdalta,ydalta;
    ViewGroup mainlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_draging);

        text = (ImageView) findViewById(R.id.text);
        mainlayout=(ViewGroup)findViewById(R.id.mainlayout);
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(50,50);
        text.setLayoutParams(layoutParams);

        text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x= (int) motionEvent.getRawX();
                int y= (int) motionEvent.getRawY();
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams layoutParams=(RelativeLayout.LayoutParams)view.getLayoutParams();
                        xdalta=x-layoutParams.leftMargin;
                        ydalta=y-layoutParams.topMargin;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams1=(RelativeLayout.LayoutParams)view.getLayoutParams();
                        layoutParams1.leftMargin=x-xdalta;
                        layoutParams1.topMargin=y-ydalta;
                        layoutParams1.rightMargin=-50;
                        layoutParams1.topMargin=-50;
                        view.setLayoutParams(layoutParams1);
                        break;
                }
                text.invalidate();
                return true;
            }
        });
    }
}

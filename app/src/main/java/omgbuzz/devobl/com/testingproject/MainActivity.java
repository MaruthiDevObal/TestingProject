package omgbuzz.devobl.com.testingproject;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import omgbuzz.devobl.com.testingproject.ColorPicker.ColorPickerActivity;
import omgbuzz.devobl.com.testingproject.ProgressBar.ProgressBarActivity;
import omgbuzz.devobl.com.testingproject.RCView.RecyclarViewActivity;
import omgbuzz.devobl.com.testingproject.ViewDraging.ViewDragingActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView lazyloading,rcView,pBar,draging,colorpicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lazyloading=(TextView)findViewById(R.id.lazyloading);
        rcView=(TextView)findViewById(R.id.rcView);
        pBar=(TextView)findViewById(R.id.pBar);
        draging=(TextView)findViewById(R.id.draging);
        colorpicker=(TextView)findViewById(R.id.colorpicker);

        lazyloading.setOnClickListener(this);
        rcView.setOnClickListener(this);
        pBar.setOnClickListener(this);
        draging.setOnClickListener(this);
        colorpicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lazyloading:
                startActivity(new Intent(MainActivity.this,LazyLoadingActivity.class));
                break;
            case R.id.rcView:
                startActivity(new Intent(MainActivity.this, RecyclarViewActivity.class));
                break;
            case R.id.pBar:
                startActivity(new Intent(MainActivity.this, ProgressBarActivity.class));
                break;
            case R.id.draging:
                startActivity(new Intent(MainActivity.this, ViewDragingActivity.class));


                
                break;
            case R.id.colorpicker:
                startActivity(new Intent(MainActivity.this, ColorPickerActivity.class));
                break;
        }
    }
}

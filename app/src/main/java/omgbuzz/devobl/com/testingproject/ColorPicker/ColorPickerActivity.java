package omgbuzz.devobl.com.testingproject.ColorPicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import omgbuzz.devobl.com.testingproject.R;
import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorPickerActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        text=(TextView)findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AmbilWarnaDialog ambilWarnaDialog=new AmbilWarnaDialog(ColorPickerActivity.this, R.color.colorAccent, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        text.setBackgroundColor(color);
                    }
                });
                ambilWarnaDialog.show();
            }
        });
    }
}

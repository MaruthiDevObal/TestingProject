package omgbuzz.devobl.com.testingproject.ProgressBar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

import omgbuzz.devobl.com.testingproject.R;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progressBar=(ProgressBar) findViewById(R.id.pBar);
    }
}

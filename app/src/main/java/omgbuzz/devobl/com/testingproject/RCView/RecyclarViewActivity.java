package omgbuzz.devobl.com.testingproject.RCView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import omgbuzz.devobl.com.testingproject.R;
import omgbuzz.devobl.com.testingproject.StudentModel;

public class RecyclarViewActivity extends AppCompatActivity {

    RecyclerView rCView;
    RCAdapterClass rcAdapterClass;
    LinearLayoutManager linearLayoutManager;
    ArrayList<StudentModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        rCView = (RecyclerView) findViewById(R.id.rCView);
        linearLayoutManager = new LinearLayoutManager(RecyclarViewActivity.this);
        rCView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<StudentModel>();
        rcAdapterClass = new RCAdapterClass(RecyclarViewActivity.this, arrayList);
        rCView.setAdapter(rcAdapterClass);
        preparedData();
        rCView.smoothScrollToPosition(50);

    }

    public void preparedData(){
        for (int i=0;i<=100;i++){
            StudentModel modalRecycler=new StudentModel();
            modalRecycler.setName("zero");
            arrayList.add(modalRecycler);
        }
        rcAdapterClass.notifyDataSetChanged();
    }
}

package omgbuzz.devobl.com.testingproject;

import android.os.Handler;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LazyLoadingActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LazyAdapter mAdapter;
    List<StudentModel> studentList;
    Handler handler;
    boolean isLoading = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_tree);

        mRecyclerView=(RecyclerView)findViewById(R.id.rcView);
        studentList = new ArrayList<StudentModel>();
        handler = new Handler();

        loadData();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new LazyAdapter(studentList);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition()
                            == studentList.size() - 1) {
                        //bottom of list!
                        loadMore();
                        isLoading = true;
                    }
                }
            }
        });
    }

    private void loadMore() {
        studentList.add(null);
        mAdapter.notifyItemInserted(studentList.size() - 1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                studentList.remove(studentList.size() - 1);
                int scrollPosition = studentList.size();
                mAdapter.notifyItemRemoved(scrollPosition);
                int currentSize = scrollPosition;
                int nextLimit = currentSize +5;
                while (currentSize - 1 < nextLimit) {
                    StudentModel studentModel = new StudentModel();
                    studentModel.setEmailId("maruthiramdevobal@gmail.com");
                    studentModel.setName("Maruthiramyadav");
                    studentList.add(studentModel);
                    currentSize++;
                }
                mAdapter.notifyDataSetChanged();
                isLoading = false;
            }
        }, 2000);
    }

    private void loadData() {
        for (int i = 1; i <= 10; i++) {
            StudentModel studentModel=new StudentModel();
            studentModel.setEmailId("maruthiramdevobal@gmail.com");
            studentModel.setName("Maruthiramyadav");
            studentList.add(studentModel);
        }
    }
}
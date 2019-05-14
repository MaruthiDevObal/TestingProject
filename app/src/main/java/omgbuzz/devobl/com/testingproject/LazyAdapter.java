package omgbuzz.devobl.com.testingproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LazyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    List<StudentModel> studentList;

    public LazyAdapter(List<StudentModel> students) {
        this.studentList=students;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {
        if (viewtype == VIEW_TYPE_ITEM) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
            return new MyViewHolder(v);
        } else {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.progress, viewGroup, false);
            return new MyProgress(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tvName.setText(studentList.get(i).getName());
            ((MyViewHolder) viewHolder).tvEmailId.setText(studentList.get(i).getEmailId());
        } else {
            ((MyProgress) viewHolder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return studentList == null ? 0 : studentList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return studentList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvEmailId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmailId = (TextView) itemView.findViewById(R.id.tvEmailId);
        }
    }

    public class MyProgress extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        public MyProgress(@NonNull View itemView) {
            super(itemView);
            progressBar=(ProgressBar)itemView.findViewById(R.id.progressBar1);
        }
    }
}

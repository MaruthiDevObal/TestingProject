package omgbuzz.devobl.com.testingproject.RCView;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import omgbuzz.devobl.com.testingproject.R;
import omgbuzz.devobl.com.testingproject.StudentModel;

public class RCAdapterClass extends RecyclerView.Adapter<RCAdapterClass.ViewHolder>{

    RecyclarViewActivity context;
    ArrayList<StudentModel> arrayList;
    public RCAdapterClass(RecyclarViewActivity recyclarViewActivity, ArrayList<StudentModel> arrayList) {
        this.context=recyclarViewActivity;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.child,parent,false);
        ViewHolder viewHolder=new ViewHolder((LinearLayout) v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.text.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        View rootview;
        public ViewHolder(LinearLayout itemView) {
            super(itemView);
            rootview=itemView;
            text=(TextView)itemView.findViewById(R.id.number);
        }
    }
}

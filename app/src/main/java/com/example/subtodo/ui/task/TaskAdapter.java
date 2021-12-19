package com.example.subtodo.ui.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.subtodo.R;
import com.example.subtodo.core.data.TaskData;
import com.example.subtodo.ui.ItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<TaskData> taskList = new ArrayList<TaskData>();
    private List<String> timeList = new ArrayList<String>();
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    public TaskAdapter(Context context, List<TaskData> list, List<String> timeList){
        this.layoutInflater = LayoutInflater.from(context);
        this.taskList = list;
        this.timeList = timeList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_task,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.time_task.setText(timeList.get(position));
        if (timeList.get(position).equals(taskList.get(position).getStartTask())){
            holder.tittle_task.setText(taskList.get(position).getTittle());
            String time = taskList.get(position).getStartTask()+"-"+taskList.get(position).getEndTask();
            holder.time_task_detail.setText(time);
            if (taskList.get(position).isStatus()){
                holder.cv_complete.setEnabled(true);
            }else {
                holder.cv_complete.setEnabled(false);
            }
        }else {
            holder.cv_task.setVisibility(View.INVISIBLE);
            holder.cv_complete.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public TaskData getItem(int id){return taskList.get(id);}

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tittle_task, time_task_detail, time_task;
        CardView cv_task, cv_complete;
        ViewHolder(View view){
            super(view);
            tittle_task = view.findViewById(R.id.tittle_task);
            time_task_detail = view.findViewById(R.id.time_task_detail);
            time_task = view.findViewById(R.id.time_task);
            cv_task = view.findViewById(R.id.cv_task);
            cv_complete = view.findViewById(R.id.cv_complete);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}

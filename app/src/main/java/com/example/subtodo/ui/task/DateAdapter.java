package com.example.subtodo.ui.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.subtodo.R;
import com.example.subtodo.core.data.TaskData;
import com.example.subtodo.ui.ItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {

    private List<TaskData> list = new ArrayList<>();
    private List<Date> dateList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;
    private boolean statusTask;

    public DateAdapter(Context context, List<TaskData> list, List<Date> dateList){
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.dateList = dateList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_date,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        if (!list.get(position).isStatus()){
            holder.imageView.setVisibility(View.INVISIBLE);
        }else {
            holder.imageView.setVisibility(View.VISIBLE);
        }

        holder.textView1.setText(new SimpleDateFormat("E", Locale.ENGLISH).format(dateList.get(position).getTime()));
        holder.textView2.setText(dateList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    public Date getItem(int id){
        return dateList.get(id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView1, textView2;
        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.img_task_info);
            textView1 = view.findViewById(R.id.day_task_info);
            textView2 = view.findViewById(R.id.date_task_info);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


}

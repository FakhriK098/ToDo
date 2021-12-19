package com.example.subtodo.ui.task;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.subtodo.core.data.TaskData;
import com.example.subtodo.databinding.FragmentTaskBinding;
import com.example.subtodo.ui.ItemClickListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskFragment extends Fragment implements ItemClickListener {

    private FragmentTaskBinding binding;
    private DateAdapter dateAdapter;
    private TaskAdapter taskAdapter;
    private List<Date> dateList = new ArrayList<Date>();
    private List<TaskData> taskDataList = new ArrayList<TaskData>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTaskBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        setDateAdapter();
        setTaskAdapter();

        return root;
    }

    private void setTaskAdapter(){
        List<String> list = getTime();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        binding.rvDetailTask.setLayoutManager(linearLayoutManager);
        taskAdapter = new TaskAdapter(getContext(), taskDataList, list);
        taskAdapter.setClickListener(this);
        binding.rvDetailTask.setAdapter(taskAdapter);
    }

    private void setDateAdapter() {
        dateList = getDate();
        taskDataList = new ArrayList<TaskData>();

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        binding.revDate.setLayoutManager(horizontalLayoutManager);
        dateAdapter = new DateAdapter(getContext(), taskDataList, dateList);
        dateAdapter.setClickListener(this);
        binding.revDate.setAdapter(dateAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List getDate(){
        List<Date> date = new ArrayList<Date>();
        String s = "1900-01-01";
        String n = "2023-30-30";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm");
        try {
            Date start = (Date)dateFormat.parse(s);
            Date end  = (Date)dateFormat.parse(n);

            long interval = 24*1000 * 60 * 60;
            long endTime = start.getTime();
            long curTime = end.getTime();

            while (curTime <= endTime){
                date.add(new Date(curTime));
                curTime+=interval;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private List getTime(){
        String time;
        List list = new ArrayList();
        for (int i=0;i<=23;i++){
            if (i>9){
                time = i+".00";
            }else {
                time = "0"+i+".00";
            }
            list.add(time);
        }
        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(),dateAdapter.getItem(position).getDate(),Toast.LENGTH_SHORT).show();
    }
}
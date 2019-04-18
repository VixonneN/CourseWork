package com.suai.sergey.fix_package.recycle_view_labWork;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.suai.sergey.R;

import java.util.List;

public class FixLabWorkAdapter extends RecyclerView.Adapter<FixLabWorkAdapter.LabWorkHolder> {

    private final List<LabWorks> labWorks;

    public FixLabWorkAdapter(List<LabWorks> labWorks) {
        this.labWorks = labWorks;
    }

    @NonNull
    @Override
    public LabWorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.lab_work_item, parent, false);
        return new LabWorkHolder(itemView);
    }

    //Вопросы - Как работать с выпадающим списком в списке, c кнопкой, условие, при котором всё будет меняться
    @Override
    public void onBindViewHolder(@NonNull LabWorkHolder labWorkHolder, int position) {
        LabWorks labWork = labWorks.get(position);
        //описать принцип работы
    }

    @Override
    public int getItemCount() {
        return labWorks.size();
    }

    static class LabWorkHolder extends RecyclerView.ViewHolder {

        public final TextView numberWork;
        public final TextView nameWork;
        public final Spinner spinner;

        public LabWorkHolder(View itemView){
            super(itemView);
                numberWork = itemView.findViewById(R.id.item_numberWork);
                nameWork = itemView.findViewById(R.id.item_nameWork);
                spinner = itemView.findViewById(R.id.item_marks);
        }
    }

}

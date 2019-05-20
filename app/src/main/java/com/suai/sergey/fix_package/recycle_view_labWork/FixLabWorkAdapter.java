package com.suai.sergey.fix_package.recycle_view_labWork;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.suai.sergey.R;
import com.suai.sergey.fix_package.FixLabWorkActivity;

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
        labWorkHolder.numberWork.setText(labWork.getNumberWork());
        labWorkHolder.nameWork.setText(labWork.getNameWork());
        if (labWork.isMarks()){
            labWorkHolder.spinnerMark.setVisibility(View.INVISIBLE);
            labWorkHolder.takeWorkButton.setVisibility(View.INVISIBLE);

            labWorkHolder.completeWork.setVisibility(View.VISIBLE);
            labWorkHolder.itemMark.setVisibility(View.VISIBLE);
            labWorkHolder.deleteMark.setVisibility(View.VISIBLE);

            labWorkHolder.itemMark.setText(String.valueOf(labWork.getMark()));
            labWorkHolder.deleteMark.setOnClickListener(v -> {
                //удаление из базы данных
            });
        } else {
            labWorkHolder.completeWork.setVisibility(View.INVISIBLE);
            labWorkHolder.itemMark.setVisibility(View.INVISIBLE);
            labWorkHolder.deleteMark.setVisibility(View.INVISIBLE);

            labWorkHolder.spinnerMark.setVisibility(View.VISIBLE);//
            labWorkHolder.takeWorkButton.setVisibility(View.VISIBLE);
            labWorkHolder.takeWorkButton.setOnClickListener(v -> {
                //запрос на добавление в базу данных
            });
        }
    }

    @Override
    public int getItemCount() {
        return labWorks.size();
    }

    static class LabWorkHolder extends RecyclerView.ViewHolder {

        public final TextView numberWork;
        public final TextView nameWork;
        public final Spinner spinnerMark;//false
        public final Button takeWorkButton;//false
        public final ImageView completeWork;//true
        public final TextView itemMark;//true
        public final ImageButton deleteMark;//true

        public LabWorkHolder(View itemView){
            super(itemView);
                numberWork = itemView.findViewById(R.id.item_numberWork);
                nameWork = itemView.findViewById(R.id.item_nameWork);
                spinnerMark = itemView.findViewById(R.id.item_spinner_marks);
                takeWorkButton = itemView.findViewById(R.id.item_buttonWork);
                completeWork = itemView.findViewById(R.id.item_complete_work);
                itemMark = itemView.findViewById(R.id.item_mark);
                deleteMark = itemView.findViewById(R.id.item_delete_mark);
        }
    }

}

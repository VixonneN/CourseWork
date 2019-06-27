package com.suai.sergey.fix_package.recycle_view_labWork;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.suai.sergey.FakeDataClass;
import com.suai.sergey.R;
import com.suai.sergey.adapters.MarkSpinnerAdapter;

import java.util.List;

public class FixLabWorkAdapter extends RecyclerView.Adapter<FixLabWorkAdapter.LabWorkHolder> {

    private final List<LabWorks> labWorks;
    private Context context;

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
        if (labWork.isMarks()) {
            //работа сдана, галочка, баллы, крестик

            labWorkHolder.takeWorkButton.setVisibility(View.INVISIBLE);
            labWorkHolder.spinnerMark.setVisibility(View.INVISIBLE);

            labWorkHolder.itemMark.setText(String.valueOf(labWork.getMark()));
            labWorkHolder.deleteMark.setOnClickListener(v -> {
                context = labWorkHolder.deleteMark.getContext();
                Toast.makeText(context, "321", Toast.LENGTH_SHORT).show();
                Log.e("123", "123");
            });
        } else {//работа не сдана, выпадающий список и кнопка

            labWorkHolder.itemMark.setVisibility(View.INVISIBLE);
            labWorkHolder.deleteMark.setVisibility(View.INVISIBLE);
            labWorkHolder.completeWork.setVisibility(View.INVISIBLE);

            context = labWorkHolder.spinnerMark.getContext();
            MarkSpinnerAdapter spinnerAdapter = new MarkSpinnerAdapter(context, FakeDataClass.INSTANCE.getIdNameNumberMaxBallWork());
            labWorkHolder.spinnerMark.setAdapter(spinnerAdapter);

            labWorkHolder.takeWorkButton.setOnClickListener(v -> {
                //запрос на добавление в базу данных
                //это работает, но не достать контекст
                context = labWorkHolder.takeWorkButton.getContext();
                Toast.makeText(context, "123", Toast.LENGTH_SHORT).show();
                Log.d("321", "1233333");
            });

        }
    }

//    private void addSpinnerAdapter(LabWorks labWork, @NonNull LabWorkHolder labWorkHolder) {
//        context = labWorkHolder.spinnerMark.getContext();
//        MarkSpinnerAdapter spinnerAdapter = new MarkSpinnerAdapter(context, FakeDataClass.INSTANCE.getIdNameNumberMaxBallWork());
//        labWorkHolder.spinnerMark.setAdapter(spinnerAdapter);
//
//    }

    //кнопка добавление записи в бд
    public interface AddDataToDataToDatabase {
        void onItemClick();
    }

    //удаление данных из бд по кнопке
    public interface DeleteDataToDatabase {
        void onItemClick();
    }

    @Override
    public int getItemCount() {
        return labWorks.size();
    }

    static class LabWorkHolder extends RecyclerView.ViewHolder {

        final TextView numberWork;
        final TextView nameWork;
        final Spinner spinnerMark;//false
        final Button takeWorkButton;//false
        final ImageView completeWork;//true
        final TextView itemMark;//true
        final ImageButton deleteMark;//true

        LabWorkHolder(View itemView) {
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

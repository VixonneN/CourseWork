package com.suai.sergey.fix_package.recycle_view_students;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.suai.sergey.R;

import java.util.List;

public class FixStudentAdapter extends RecyclerView.Adapter<FixStudentAdapter.StudentsHolder> {

    private List<StudentsData> studentsDataList;

    private OnItemClickListener onItemClickListener;

    public FixStudentAdapter(List<StudentsData> studentsDataList, OnItemClickListener onItemClickListener) {
        this.studentsDataList = studentsDataList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public StudentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.students_item, parent, false);

        final StudentsHolder holder = new StudentsHolder(itemView);
        holder.nameStudents.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {//условия перехода
                StudentsData studentsData = this.studentsDataList.get(position);
                onItemClickListener.onItemClick(studentsData, position);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsHolder studentsHolder, int positions) {
        StudentsData studentsData = this.studentsDataList.get(positions);
        studentsHolder.nameStudents.setText(studentsData.getNameStudent());
        studentsHolder.numberStudentInGroup.setText(String.valueOf(studentsData.getNumberStudentFromGroup()));
    }

//    public void updateList(List<Student> updatedList) {
//        mNoteList = updatedList;
//        notifyDataSetChanged();
//    }

    @Override
    public int getItemCount() {
        return studentsDataList.size();
    }

    static class StudentsHolder extends RecyclerView.ViewHolder {

        private final TextView numberStudentInGroup;
        private final TextView nameStudents;

        private StudentsHolder(View view) {
            super(view);
            nameStudents = view.findViewById(R.id.item_text_view);
            numberStudentInGroup = view.findViewById(R.id.item_number_student_in_group);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(@NonNull StudentsData studentsData, int position);
    }
}

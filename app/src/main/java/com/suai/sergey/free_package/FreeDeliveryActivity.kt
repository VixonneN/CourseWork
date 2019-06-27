package com.suai.sergey.free_package

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.suai.sergey.FakeDataClass
import com.suai.sergey.R
import com.suai.sergey.adapters.GroupSpinnerAdapter
import com.suai.sergey.adapters.StudentSpinnerAdapter
import com.suai.sergey.adapters.SubjectSpinnerAdapter
import com.suai.sergey.adapters.WorkSpinnerAdapter
import com.suai.sergey.databases.groupDatabase.NumberGroup
import com.suai.sergey.databases.studentDatabase.FioStudent
import com.suai.sergey.databases.subjectDatabase.SubjectName
import com.suai.sergey.databases.workDatabase.NameWork
import java.util.*

class FreeDeliveryActivity : AppCompatActivity() {

    internal var textSpinner: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free_delivery)
        GroupSpinner()
        studentSpinner()
        subjectSpinner()
        labWorkSpinner()
        deliveryButton()
        markSpinner()

        val actionBar = supportActionBar
        actionBar!!.setHomeButtonEnabled(true)
        actionBar.run {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun GroupSpinner() {
        val groupSpinner = findViewById<Spinner>(R.id.sv1)
        val groupSpinnerAdapter = GroupSpinnerAdapter(this, FakeDataClass.INSTANCE.groupList)
        groupSpinner.adapter = groupSpinnerAdapter

        groupSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position != 0) {
                    val nb = parent.getItemAtPosition(position) as NumberGroup
                    val item = nb.number.toString()
                    makeToast(item)
                    textSpinner.add(0, item)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun studentSpinner() {
        val studSpinner = findViewById<Spinner>(R.id.sv2)
        val studentSpinnerAdapter = StudentSpinnerAdapter(this, FakeDataClass.INSTANCE.studentList)
        studSpinner.adapter = studentSpinnerAdapter

        studSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position != 0) {
                    val fioStudent = parent.getItemAtPosition(position) as FioStudent
                    textSpinner.add(1, fioStudent.fio)
                    val item = fioStudent.fio.toString()
                    makeToast(item)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun subjectSpinner() {
        val discipline = findViewById<Spinner>(R.id.sv3)
        val subjectSpinnerAdapter = SubjectSpinnerAdapter(this, FakeDataClass.INSTANCE.subjectList)
        discipline.adapter = subjectSpinnerAdapter

        discipline.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position != 0) {
                    val subjectName = parent.getItemAtPosition(position) as SubjectName
                    val item = subjectName.name.toString()
                    makeToast(item)
                    textSpinner.add(2, subjectName.name)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

    }

    private fun labWorkSpinner() {
        val workSpinner = findViewById<Spinner>(R.id.sv4)
        val workSpinnerAdapter = WorkSpinnerAdapter(this, FakeDataClass.INSTANCE.workList)
        workSpinner.adapter = workSpinnerAdapter

        workSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position != 0) {
                    val nameWork = parent.getItemAtPosition(position) as NameWork
                    textSpinner.add(3, nameWork.name)
                    val item = nameWork.name.toString()
                    makeToast(item)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun markSpinner() {
        val markSpinner = findViewById<Spinner>(R.id.markSpinnerFree)
        val adapter = ArrayAdapter.createFromResource(this, R.array.marks, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter.addAll()
        markSpinner.adapter = adapter
        markSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var item = parent.getItemAtPosition(position) as String
                item = item
                makeToast(item)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun deliveryButton() {
        val fixDelivery = findViewById<Button>(R.id.deliveryBtnFree)
        fixDelivery.setOnClickListener { v ->
            //                makeToast("Тут должен быть ответ в базу данных :D");
            val getMap = textSpinner[0] + " " + textSpinner[1] + " " + textSpinner[2] + " " + textSpinner[3] + " c оценкой " /*+ textSpinner.get(4)*/
            makeToast(getMap)
        }
    }

    private fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}

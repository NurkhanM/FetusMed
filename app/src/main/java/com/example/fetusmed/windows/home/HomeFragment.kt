package com.example.fetusmed.windows.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        root.calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            Toast.makeText(requireContext(), "Data : $i3.$i2.$i", Toast.LENGTH_SHORT).show()
        }

        root.calendarView.weekSeparatorLineColor = R.color.fon

        root.button.setOnClickListener {
//            val selectedDate = root.calendarView.date
//            val calendar = Calendar.getInstance()
//            calendar.timeInMillis = selectedDate
//            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
//            root.textView.text = "Selected date: ${dateFormatter.format(calendar.time)}"

            //Назначить дату
//            val calendar = Calendar.getInstance()
//            calendar.set(
//                2020,
//                6,
//                27
//            )
//            calendarView.date = calendar.timeInMillis
//            root.calendarView.setDate(calendar.timeInMillis, true, true)
        }

        return root
    }

}
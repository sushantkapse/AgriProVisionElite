package com.example.agriprovisionelite.testing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.agriprovisionelite.R;
import java.util.ArrayList;
import java.util.List;

public class BarPlotTesting extends Fragment {
    private BarChart barChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar_p_lottesting, container, false);
        barChart = view.findViewById(R.id.bar_chart);

        // Static data for activities and expenses
        String[] activities = {"a1", "b1", "c1", "d1", "e1"};
        float[] expenses = {10f, 20f, 30f, 10f, 40f};

        populateBarChart(activities, expenses);

        return view;
    }

    private void populateBarChart(String[] activities, float[] expenses) {
        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < activities.length; i++) {
            entries.add(new BarEntry(i, expenses[i], activities[i]));
        }

        BarDataSet dataSet = new BarDataSet(entries, "Crop Expenses");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextSize(12f);

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setFitBars(true);
        barChart.invalidate();
    }
}
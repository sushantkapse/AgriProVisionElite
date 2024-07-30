package com.example.agriprovisionelite.testing;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.agriprovisionelite.R;
import java.util.ArrayList;
import java.util.List;

public class FragTest extends Fragment {
    private PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_test, container, false);
        pieChart = view.findViewById(R.id.pie_chart);

        // Static data for activities and expenses
        String[] activities = {"a1", "b1", "c1", "d1", "e1"};
        float[] expenses = {10f, 20f, 30f, 10f, 40f};

        populatePieChart(activities, expenses);

        return view;
    }

    private void populatePieChart(String[] activities, float[] expenses) {
        List<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < activities.length; i++) {
            entries.add(new PieEntry(expenses[i], activities[i]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Crop Expenses");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextSize(12f);

        PieData pieData = new PieData(dataSet);
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        pieChart.setData(pieData);
        pieChart.setEntryLabelColor(R.color.black);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Crop Expenses");
        pieChart.animateY(1000);
        pieChart.invalidate();
    }
}


//import android.database.Cursor;
//        import android.os.Bundle;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import androidx.annotation.NonNull;
//        import androidx.annotation.Nullable;
//        import androidx.fragment.app.Fragment;
//        import com.github.mikephil.charting.charts.PieChart;
//        import com.github.mikephil.charting.data.PieData;
//        import com.github.mikephil.charting.data.PieDataSet;
//        import com.github.mikephil.charting.data.PieEntry;
//        import com.github.mikephil.charting.formatter.PercentFormatter;
//        import com.github.mikephil.charting.utils.ColorTemplate;
//        import com.example.agriprovisionelite.DataBase;
//        import com.example.agriprovisionelite.R;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class PieChartFragment extends Fragment {
//    private DataBase dbHelper;
//    private PieChart pieChart;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        dbHelper = new DataBase(requireContext());
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
//        pieChart = view.findViewById(R.id.pie_chart);
//
//        // Fetch data from database and populate pie chart
//        populatePieChart();
//
//        return view;
//    }
//
//    private void populatePieChart() {
//        List<PieEntry> entries = new ArrayList<>();
//        Cursor cursor = dbHelper.getCropExpensesData();
//
//        if (cursor != null && cursor.moveToFirst()) {
//            do {
//                String activity = cursor.getString(cursor.getColumnIndex("activities"));
//                float cost = cursor.getFloat(cursor.getColumnIndex("expenses"));
//                entries.add(new PieEntry(cost, activity));
//            } while (cursor.moveToNext());
//            cursor.close();
//        }
//
//        PieDataSet dataSet = new PieDataSet(entries, "Crop Expenses");
//        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
//        dataSet.setValueTextSize(12f);
//
//        PieData pieData = new PieData(dataSet);
//        pieData.setValueFormatter(new PercentFormatter(pieChart));
//        pieChart.setData(pieData);
//        pieChart.setEntryLabelColor(R.color.black);
//        pieChart.getDescription().setEnabled(false);
//        pieChart.setCenterText("Crop Expenses");
//        pieChart.animateY(1000);
//        pieChart.invalidate();
//    }
//}

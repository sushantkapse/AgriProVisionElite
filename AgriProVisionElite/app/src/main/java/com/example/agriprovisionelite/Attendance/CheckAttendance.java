package com.example.agriprovisionelite.Attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class CheckAttendance extends AppCompatActivity {

    SQLiteDatabase db;
    DataBase dbHelper;
    private EditText idEditText;
    private TableLayout attendanceTableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_attendance);
        dbHelper = new DataBase(this);
        db = dbHelper.getWritableDatabase();
        idEditText = findViewById(R.id.idEditText);
        attendanceTableLayout = findViewById(R.id.attendanceTableLayout);

        Button retrieveButton = findViewById(R.id.retrieveButton);
        retrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveAttendanceData();
            }
        });
    }

    private void retrieveAttendanceData() {
        String id = idEditText.getText().toString().trim();

        // Clear existing rows in the table
        attendanceTableLayout.removeAllViews();

        // Query to retrieve data from LaborsAttendance for the specified l_id
        String query = "SELECT Date, Attendance_status FROM LaborsAttendance WHERE l_id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{id});

        if (cursor != null && cursor.moveToFirst()) {
            int dateIndex = cursor.getColumnIndex("Date");
            int statusIndex = cursor.getColumnIndex("Attendance_status");

            do {
                if (dateIndex != -1 && statusIndex != -1) {
                    String date = cursor.getString(dateIndex);
                    int statusValue = cursor.getInt(statusIndex);
                    boolean status = statusValue == 1;

                    // Convert boolean status to "Present" or "Absent" for display
                    String statusString = status ? "Present": "Absent";

                    // Create a new row for each entry in the cursor
                    TableRow row = new TableRow(this);
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT
                    );
                    row.setLayoutParams(layoutParams);
                    layoutParams.setMargins(0, 0, 0, 8);

                    // Create TextViews for Date and Status
                    TextView dateTextView = new TextView(this);
                    dateTextView.setText(date);
                    dateTextView.setGravity(Gravity.CENTER);
                    dateTextView.setPadding(8, 8, 8, 8);


                    row.addView(dateTextView);

                    TextView statusTextView = new TextView(this);
                    statusTextView.setText(statusString);
                    statusTextView.setGravity(Gravity.CENTER);
                    statusTextView.setPadding(200, 30, 8, 8);
                    row.setBackground(getResources().getDrawable(R.drawable.row_border)); // Assuming row_border.xml is in res/drawable folder

                    row.addView(statusTextView);

                    // Add the row to the table layout
                    attendanceTableLayout.addView(row);
                } else {
                    // Handle case where column indices are not found
                    // For example, log an error or show a message to the user
                    // You can also skip adding this row to the table
                }
            } while (cursor.moveToNext());
            cursor.close();
        }
    }

}
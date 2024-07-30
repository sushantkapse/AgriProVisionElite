package com.example.agriprovisionelite.Crop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class Expenses_Adapter extends RecyclerView.Adapter<Expenses_Adapter.viewHolder> {

    Context context;

    ArrayList expense_id,activity,amount,date;

    public Expenses_Adapter(Context context, ArrayList expense_id, ArrayList activity, ArrayList amount,ArrayList date) {
        this.context = context;
        this.expense_id = expense_id;
        this.activity = activity;
        this.amount = amount;
        this.date = date;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_crop_expenses,null);
        return  new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.textViewExpenseId.setText(String.valueOf(expense_id.get(position)));
        holder.textViewActivity.setText(String.valueOf(activity.get(position)));
        holder.textViewAmount.setText(String.valueOf(amount.get(position)));
        holder.textViewDate.setText(String.valueOf(date.get(position)));



    }

    @Override
    public int getItemCount() {
        return expense_id.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textViewExpenseId,textViewActivity,textViewDate,textViewAmount;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textViewExpenseId = (TextView) itemView.findViewById(R.id.textViewExpenseId);
            textViewActivity = (TextView) itemView.findViewById(R.id.textViewActivity);
            textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
            textViewAmount = (TextView) itemView.findViewById(R.id.textViewAmount);
        }
    }
}

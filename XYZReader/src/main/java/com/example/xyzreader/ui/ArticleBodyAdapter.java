package com.example.xyzreader.ui;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ArticleBodyAdapter extends RecyclerView.Adapter<ArticleBodyAdapter.ArticleBodyViewHolder> {

    private List<String> paragraphList;

    ArticleBodyAdapter(List<String> paragraphList) {
        this.paragraphList = paragraphList;
    }

    @NonNull
    @Override
    public ArticleBodyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleBodyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paragraph, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleBodyViewHolder holder, int position) {
        if (position == 1) {
            SpannableString spanString = new SpannableString((paragraphList.get(position).trim()));
            spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
            holder.paragraph.setText(spanString);
        } else holder.paragraph.setText(paragraphList.get(position).trim());
    }

    @Override
    public int getItemCount() {
        return paragraphList.size();
    }

    class ArticleBodyViewHolder extends RecyclerView.ViewHolder {

        TextView paragraph;

        ArticleBodyViewHolder(@NonNull View itemView) {
            super(itemView);
            paragraph = (TextView) itemView;
        }
    }
}
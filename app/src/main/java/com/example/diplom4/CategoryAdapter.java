package com.example.diplom4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<String> categories;
    private OnItemClickListener listener;

    public CategoryAdapter(List<String> categories, OnItemClickListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String category = categories.get(position);
        holder.bind(category, listener);

        // Устанавливаем изображение для каждой категории
        int imageResource = 0;
        switch (category) {
            case "Жемістер":
                imageResource = R.drawable.fruct;
                break;
            case "Сандар":
                imageResource = R.drawable.sandar;
                break;
            case "Отбасы":
                imageResource = R.drawable.fam;
                break;
            case "Жануарлар":
                imageResource = R.drawable.animal;
                break;
            case "Үй":
                imageResource = R.drawable.home;
                break;
            case "Ойын":
                imageResource = R.drawable.game;
            case "Көкөністер":
                imageResource = R.drawable.ovos;
                break;
            case "Түстер":
                imageResource = R.drawable.color;
                break;
            case "Сөздер ойыны":
                imageResource = R.drawable.soztabu;
                break;
            case "Жемістер ойыны":
                imageResource = R.drawable.fruct;
                break;

        }
        holder.categoryImage.setImageResource(imageResource);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryImage;
        private TextView categoryName;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            categoryName = itemView.findViewById(R.id.categoryName);
        }

        public void bind(final String category, final OnItemClickListener listener) {
            categoryName.setText(category);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(category);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String category);
    }
}

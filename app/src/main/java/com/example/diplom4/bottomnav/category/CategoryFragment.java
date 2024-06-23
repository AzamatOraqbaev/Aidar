package com.example.diplom4.bottomnav.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplom4.Category6Activity;
import com.example.diplom4.CategoryAdapter;
import com.example.diplom4.Category1Activity;
import com.example.diplom4.Category2Activity;
import com.example.diplom4.Category3Activity;
import com.example.diplom4.Category4Activity;
import com.example.diplom4.Category5Activity;
import com.example.diplom4.GameActivity;
import com.example.diplom4.QuizActivity;
import com.example.diplom4.databinding.FragmentCategoryBinding;
import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    private FragmentCategoryBinding binding;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Создаем список категорий
        List<String> categories = new ArrayList<>();
        categories.add("Жемістер");
        categories.add("Сандар");
        categories.add("Отбасы");
        categories.add("Жануарлар");
        categories.add("Көкөністер");
        categories.add("Түстер");

        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Создаем адаптер и устанавливаем его для RecyclerView
        adapter = new CategoryAdapter(categories, new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String category) {
                // Обработка нажатия на категорию
                Intent intent;
                switch (category) {
                    case "Жемістер":
                        intent = new Intent(getActivity(), Category1Activity.class);
                        break;
                    case "Сандар":
                        intent = new Intent(getActivity(), Category2Activity.class);
                        break;
                    case "Отбасы":
                        intent = new Intent(getActivity(), Category3Activity.class);
                        break;
                    case "Жануарлар":
                        intent = new Intent(getActivity(), Category4Activity.class);
                        break;
                    case "Көкөністер":
                        intent = new Intent(getActivity(), Category5Activity.class);
                        break;
                    case "Түстер":
                        intent = new Intent(getActivity(), Category6Activity.class);
                        break;
                    default:
                        return;
                }
                intent.putExtra("category", category);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

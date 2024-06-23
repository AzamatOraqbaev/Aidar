package com.example.diplom4.bottomnav.game;

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

import com.example.diplom4.Category1Activity;
import com.example.diplom4.Category2Activity;
import com.example.diplom4.Category3Activity;
import com.example.diplom4.Category4Activity;
import com.example.diplom4.Category5Activity;
import com.example.diplom4.CategoryAdapter;
import com.example.diplom4.GameActivity;
import com.example.diplom4.GameFructActiivity;
import com.example.diplom4.GameSandarActiivity;
import com.example.diplom4.QuizActivity;
import com.example.diplom4.databinding.FragmentGameBinding;
import java.util.ArrayList;
import java.util.List;

public class GameFragment extends Fragment {
    private FragmentGameBinding binding;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Создаем список категорий
        List<String> categories = new ArrayList<>();
        categories.add("Жемістер");
        categories.add("Отбасы");
        categories.add("Сөздер ойыны");
        categories.add("Сандар");
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        // Создаем адаптер и устанавливаем его для RecyclerView
        adapter = new CategoryAdapter(categories, new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String category) {
                // Обработка нажатия на категорию

                Intent intent = new Intent(getActivity(), GameActivity.class);

                switch (category) {
                    case "Жемістер":
                        intent = new Intent(getActivity(), GameSandarActiivity.class);
                        break;
                    case "Отбасы":
                        intent = new Intent(getActivity(), GameActivity.class);
                        break;
                    case "Сөздер ойыны":
                        intent = new Intent(getActivity(), QuizActivity.class);
                        break;
                    case "Сандар":
                        intent = new Intent(getActivity(), GameFructActiivity.class);
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

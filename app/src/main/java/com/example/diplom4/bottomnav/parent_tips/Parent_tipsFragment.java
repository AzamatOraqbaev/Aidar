package com.example.diplom4.bottomnav.parent_tips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.diplom4.databinding.FragmentGameBinding;
import com.example.diplom4.databinding.FragmentParentTipsBinding;

public class Parent_tipsFragment extends Fragment {
    private FragmentParentTipsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentParentTipsBinding.inflate(inflater, container, false);



        return  binding.getRoot();

    }
}
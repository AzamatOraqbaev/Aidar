package com.example.diplom4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.diplom4.bottomnav.category.CategoryFragment;
import com.example.diplom4.bottomnav.parent_tips.Parent_tipsFragment;
import com.example.diplom4.bottomnav.game.GameFragment;
import com.example.diplom4.databinding.ActivityCategoryBinding;
import java.util.HashMap;
import java.util.Map;

public class CategoryActivity extends AppCompatActivity {
    private ActivityCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), new CategoryFragment()).commit();
        binding.bottomNavigation.setSelectedItemId(R.id.category);

        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.category, new CategoryFragment());
        fragmentMap.put(R.id.game, new GameFragment());
        fragmentMap.put(R.id.parent_tips, new Parent_tipsFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), fragment).commit();
                return true;
            }
            return false;
        });
    }
}

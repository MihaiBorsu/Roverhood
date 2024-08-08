package com.example.roverhood;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.roverhood.databinding.LogInBinding;
import com.example.roverhood.databinding.RoverFeedBinding;

import java.util.Objects;

public class LogIn extends Fragment {

    private LogInBinding binding;
    boolean loggedIn = false;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = LogInBinding.inflate(inflater, container, false);

        if(loggedIn) {
            NavHostFragment.findNavController(LogIn.this)
                    .navigate(R.id.action_LogIn_to_loading);
        }

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.roverhood;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.roverhood.databinding.LogInBinding;
import com.example.roverhood.databinding.RoverFeedBinding;

public class RoverFeed extends Fragment {

    private RoverFeedBinding binding;
    MainActivity main;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = RoverFeedBinding.inflate(inflater, container, false);
        main = (MainActivity) getParentFragment().getActivity();
        main.onFeed = true;

        float density = getActivity().getResources().getDisplayMetrics().density;
        int dpValue = (int) (density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(10*dpValue, 10*dpValue, 10*dpValue, 10*dpValue);

        LinearLayout.LayoutParams dividerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                (int) ( 4 * density)
        );
        dividerParams.setMargins(10*dpValue, 10*dpValue, 10*dpValue, 10*dpValue);

        LinearLayout.LayoutParams dateParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        dateParams.setMargins(10*dpValue, 10*dpValue, 10*dpValue, 0*dpValue);
        ;
        View linearLayout = binding.getRoot().findViewById(R.id.info);

        for(int i = 0; i<3; i++) {
            TextView date = new TextView(getActivity());
            date.setText("19 iunie 2024  -  14:32");
            date.setLayoutParams(dateParams);
            date.setTypeface(date.getTypeface(), Typeface.BOLD);
            ((LinearLayout) linearLayout).addView(date);

            TextView postText = new TextView(getActivity());
            postText.setText("Este o zi frumoasa astazi la Roverhood!");
            postText.setLayoutParams(params);
            ((LinearLayout) linearLayout).addView(postText);

            //ImageView Setup
            ImageView imageView = new ImageView(getActivity());
            if (i == 0)
                imageView.setImageResource(R.drawable.img1);
            else if (i == 1)
                imageView.setImageResource(R.drawable.img2);
            else
                imageView.setImageResource(R.drawable.img3);
            imageView.setId(i);
            imageView.setLayoutParams(params);
            imageView.setAdjustViewBounds(true);
            ((LinearLayout) linearLayout).addView(imageView);

            //Divider Setup
            androidx.cardview.widget.CardView divider = new androidx.cardview.widget.CardView(getActivity());
            divider.setLayoutParams(dividerParams);
            divider.setCardBackgroundColor(getResources().getColor(R.color.light_purple));
            divider.setRadius((int) ( 5 * density));
            if(i!=2) {
                ((LinearLayout) linearLayout).addView(divider);
            }
        }

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        main.onFeed = false;
        super.onDestroyView();
        binding = null;

    }
}
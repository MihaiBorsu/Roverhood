package com.example.roverhood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.roverhood.databinding.RoverFeedBinding;

public class RoverFeed extends Fragment {

    private RoverFeedBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(40, 40, 40, 40);

        //binding = RoverFeedBinding.inflate(inflater, container, false);
        View mContainer = inflater.inflate(R.layout.rover_feed, null);
        View linearLayout = mContainer.findViewById(R.id.info);

        for(int i = 0; i<3; i++) {
            TextView postText = new TextView(getActivity());
            postText.setText("Este o zi frumoasa astazi la Roverhood!");
            postText.setLayoutParams(params);
            ((LinearLayout) linearLayout).addView(postText);

            //ImageView Setup
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.drawable.image1);
            imageView.setLayoutParams(params);
            ((LinearLayout) linearLayout).addView(imageView);

            //Divider Setup
            View divider = new View(getActivity());
            divider.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    10));
            divider.setBackgroundResource(R.color.light_purple);
            ((LinearLayout) linearLayout).addView(divider);
        }

        return mContainer;
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
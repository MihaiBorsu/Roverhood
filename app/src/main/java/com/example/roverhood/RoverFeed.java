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

import java.util.Vector;

public class RoverFeed extends Fragment {

    private RoverFeedBinding binding;
    Vector<Post> posts = new Vector<Post>();
    Vector<Post> announcements = new Vector<Post>();
    MainActivity main;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = RoverFeedBinding.inflate(inflater, container, false);
        main = (MainActivity) getParentFragment().getActivity();
        main.onFeed = true;

        LinearLayout linearLayout = binding.getRoot().findViewById(R.id.info);

        populatePosts();

        if(main.onlyAnnouncements) {
            for(Post post : announcements) {
                linearLayout.addView(post.getUserView());
                linearLayout.addView(post.getDateView());
                linearLayout.addView(post.getDescriptionView());
                linearLayout.addView(post.getImageView());
                if(post != posts.lastElement()) {
                    linearLayout.addView(post.getDividerView());
                }
            }
        }
        else {
            for(Post post : posts) {
                linearLayout.addView(post.getUserView());
                linearLayout.addView(post.getDateView());
                linearLayout.addView(post.getDescriptionView());
                linearLayout.addView(post.getImageView());
                if(post != posts.lastElement()) {
                    linearLayout.addView(post.getDividerView());
                }
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

    private void populatePosts() {
        Post temp = new Post(this,
                "21 iunie 2024  -  00:17","David",
                "Este o zi frumoasa astazi la Roverhood!",
                R.drawable.img1);

        Post temp2 = new Post(this,
                "20 iunie 2024  -  15:12",
                "David",
                "Vaii.. nu va pot spune! Am fost recent la popa la biserica, si i-am marturisit ca nu am fost un boier cuminte. Am alergat numai dupa bani, si sper sincer sa scap cu basma curata!",
                R.drawable.img2);

        Post temp3 = new Post(this,
                "19 iunie 2024  -  14:32",
                "David",
                "Dupa atata asteptare, in sfarsit s-a maritat si fiica boierului!",
                R.drawable.img3);
        Post temp4 = new Post(this,
                "10 iunie 2024  -  00:00",
                "Admin",
                "S-au pornit inscrierile! La treaba!",
                R.drawable.title);

        posts.add(temp);
        posts.add(temp2);
        posts.add(temp3);
        posts.add(temp4);

        for(Post post : posts) {
            if(post.isAnnouncement())
                announcements.add(post);
        }
    }

    public void resetFeed(){

    }
}
package com.example.mystaticimageapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://i.imgur.com/eoWyMMW.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

        // Load the image from the URL using Glide
        Glide.with(this)
             .load(IMAGE_URL)
             .apply(new RequestOptions().override(Target.SIZE_ORIGINAL))
             .diskCacheStrategy(DiskCacheStrategy.ALL)
             .listener(new RequestListener<Drawable>() {
                 @Override
                 public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                     Log.e("Glide", "Image load failed", e);
                     return false; // important to return false so the error placeholder can be placed
                 }

                 @Override
                 public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                     Log.d("Glide", "Image loaded successfully");
                     return false;
                 }
             })
             .into(imageView);
    }
}

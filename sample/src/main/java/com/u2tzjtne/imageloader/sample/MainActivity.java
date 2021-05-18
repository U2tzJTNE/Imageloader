package com.u2tzjtne.imageloader.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.u2tzjtne.imageloader.ImageLoader;

/**
 * @author u2tzjtne
 */
public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private String imageUrl = "https://avatars1.githubusercontent.com/u/20137053?s=400";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    public void downloadImage(View view) {
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.displayImage(imageUrl, imageView);
    }
}

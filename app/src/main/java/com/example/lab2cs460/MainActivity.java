package com.example.lab2cs460;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        final ViewPager2 viewViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();

        VideoItem videoClip1 = new VideoItem();
        videoClip1.videoURL = "https://firebasestorage.googleapis.com/v0/b/lab2cs460.appspot.com/o/1v3%20Sheriff.mp4?alt=media&token=066c2319-4d78-45fe-9f0e-9240cf28ca6f";
        videoClip1.videoTitle = "1v3 Win";
        videoClip1.videoID = "ID: 08293473";
        videoClip1.videoDescription = "Winning a 1v3 in Valorant with sheriff";
        videoItemsList.add(videoClip1);

        VideoItem videoClip2 = new VideoItem();
        videoClip2.videoURL = "https://firebasestorage.googleapis.com/v0/b/lab2cs460.appspot.com/o/1v4%20pistol.mp4?alt=media&token=a47d850f-163a-4c65-8859-aceea0258268";
        videoClip2.videoTitle = "4 Kills!";
        videoClip2.videoID = "ID: 43802935";
        videoClip2.videoDescription = "4 kills with a ghost in Valorant";
        videoItemsList.add(videoClip2);

        VideoItem videoClip3 = new VideoItem();
        videoClip3.videoURL = "https://firebasestorage.googleapis.com/v0/b/lab2cs460.appspot.com/o/Clean%20Ace.mp4?alt=media&token=ba8e9c1d-d9af-4655-8ef0-15705cb49036";
        videoClip3.videoTitle = "Vandal Ace";
        videoClip3.videoID = "ID: 27892304";
        videoClip3.videoDescription = "10 Second Ace Valorant";
        videoItemsList.add(videoClip3);



        viewViewPager.setAdapter(new VideoAdapter(videoItemsList));


    }
}
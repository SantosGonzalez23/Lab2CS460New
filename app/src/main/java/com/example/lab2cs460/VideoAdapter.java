package com.example.lab2cs460;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    /**
     * Constructor for VideoAdapter.
     *
     * @param videoItem List of VideoItem objects to be displayed in the RecyclerView.
     */
    public VideoAdapter(List<VideoItem> videoItem) {
        this.videoItems = videoItem;
    }

    /**
     * Creates a new VideoViewHolder when the RecyclerView needs a new ViewHolder to represent an item.
     *
     * @param parent   The ViewGroup into which the new View will be added.
     * @param viewType The view type of the new View.
     * @return A new instance of VideoViewHolder.
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video,parent,false)
        );
    }

    /**
     * Binds the data from the videoItems list to the provided ViewHolder.
     *
     * @param holder   The ViewHolder which should be updated to represent the content of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));

    }
    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the data set.
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }


    /**
     * ViewHolder class for holding the views for each video item.
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder{

        TextView textVideoTitle1, textVideoDescription1, textVideoID1;

        VideoView videoView;

        ProgressBar progressBar;
        /**
         * Constructor for VideoViewHolder.
         *
         * @param itemView The view to be held by this ViewHolder.
         */
            public VideoViewHolder(@NonNull View itemView) {
                super(itemView);
                videoView = itemView.findViewById(R.id.videoView);
                textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
                textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);
                textVideoID1 = itemView.findViewById(R.id.textVideoID);
                progressBar = itemView.findViewById(R.id.videoProgressBar);
            }

        /**
         * Sets the video data to the views.
         *
         * @param videoItem The VideoItem object containing video data.
         */
            void setVideoData(VideoItem videoItem){
                textVideoTitle1.setText(videoItem.videoTitle);
                textVideoDescription1.setText(videoItem.videoDescription);
                textVideoID1.setText(videoItem.videoID);
                videoView.setVideoPath(videoItem.videoURL);

                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        progressBar.setVisibility(View.GONE);
                        mp.start();

                        float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                        float screenRatio = videoView.getWidth()/(float) videoView.getHeight();

                        float scale = videoRatio / screenRatio;
                        if(scale >=1f){
                            videoView.setScaleX(scale);
                        }else{
                            videoView.setScaleY(1f / scale);
                        }
                    }

                });

                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.start();
                    }
                });
            }

    }



}

package csc319.example.videospringdemo.repository;

import csc319.example.videospringdemo.controller.Video;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class VideoModel implements VideoRepository{

    private Set<Video> videoSet = Collections.newSetFromMap(new ConcurrentHashMap<Video, Boolean>());
    @Override
    public boolean addVideo(Video v){
        return videoSet.add(v);
    }
    @Override
    public Collection<Video> getVideos(){
        return videoSet;
    }
    public Collection<Video> findByTitle(String title){
        Set<Video> matches = new HashSet<>();
        for(Video video: videoSet){
            if(video.getName().equals(title)){
                matches.add(video);
            }
        }
        return matches;
    }
}

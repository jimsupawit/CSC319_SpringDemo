package csc319.example.videospringdemo.controller;

import csc319.example.videospringdemo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


//Tell Spring That this class is controller that handle HTTP requests for dispatcher
@Controller
public class VideoController {
    @Autowired
    private VideoRepository videos;
    public static final String VIDEO_CONTROLLER_PATH = "/video";
    public static final String VIDEO_CONTROLLER_SEARCH_PATH = "/videosearch";
    // In-memory list that store the videos
//    private List<Video> videos = new ArrayList<Video>();

    // Receives POST request to /video and convert the HTTP request body
    @RequestMapping(value = VIDEO_CONTROLLER_PATH, method = RequestMethod.GET)
    public @ResponseBody Collection<Video> getVideos() {
        return videos.getVideos();
    }

    @RequestMapping(value = VIDEO_CONTROLLER_PATH, method = RequestMethod.POST)
    public @ResponseBody boolean addVideos(Video v) {
        return videos.addVideo(v);
    }
    private static final String TITLE_PARAMETER = "";
    @RequestMapping(value=VIDEO_CONTROLLER_SEARCH_PATH, method= RequestMethod.GET)
    public @ResponseBody Collection<Video> findByTitle(@RequestParam(TITLE_PARAMETER) String title){
        return videos.findByTitle(title);
    }
}
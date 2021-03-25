package com.example.music;

import com.example.music.tracks.Track;
import com.example.music.tracks.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    private final TrackRepository trackRepository;
    @Autowired
    public PageController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/API")
    public String Api(){
        return "API";
    }

}

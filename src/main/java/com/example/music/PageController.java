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
    @GetMapping
    public String main() {
        return "index" ;
    }
    @GetMapping("/")
    public String add(Model model){
        model.addAttribute("track", new Track());
        return "index";
    }
    @PostMapping("/")
    public String post(@ModelAttribute Track track, Model model){
        model.addAttribute("track", track);
        trackRepository.save(track);
        return "index";
    }
}

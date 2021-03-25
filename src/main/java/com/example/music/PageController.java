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
    public String index(Model model) {
        model.addAttribute("alltracks", trackRepository.findAll());
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/Adding")
    public String add(Model model){
        model.addAttribute("track", new Track());
        return "Adding";
    }
    @PostMapping("/Adding")
    public String post(@ModelAttribute Track track, Model model){
        model.addAttribute("track", track);
        trackRepository.save(track);
        return "index";
    }
}

package com.example.music.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class TrackController {
    private final TrackService trackService;
    private final TrackRepository trackRepository;
    @Autowired
    public TrackController(TrackService trackService, TrackRepository trackRepository) {
        this.trackService = trackService;
        this.trackRepository=trackRepository;
    }

    @GetMapping("")
    public String getAllTrack(Model model){
        model.addAttribute("alltracks",trackService.getAllTracks());
        return "index";
    }
    @GetMapping("tracks/{trackId}")
    public String getTrack(@PathVariable ("trackId") Long trackId, Model model){
        if(!trackRepository.existsById(trackId)){
            return "redirect:/";
        }
        model.addAttribute("track", trackService.getTrackById(trackId));
        return "oneTrack";
    }
    @GetMapping("/Adding")
    public String add(Model model){
        model.addAttribute("track", new Track());
        return "Adding";
    }
    @PostMapping("/Adding")
    public String newTrack(@RequestBody @ModelAttribute Track track, Model model){
        model.addAttribute("track", track);
        trackService.addNewTrack(track);
        return "redirect:/tracks/"+track.getId();
    }
    @PostMapping("tracks/{trackId}/delete")
    public String deleteTrack(@PathVariable ("trackId") Long trackId){
        trackService.deleteTrack(trackId);
        return "redirect:/";
    }
    @GetMapping("tracks/{trackId}/edit")
    public String getUpdateTrack(@PathVariable ("trackId") Long trackId, Model model){
        if(!trackRepository.existsById(trackId)){
            return "redirect:/tracks/"+trackId;
        }
        model.addAttribute("track", trackRepository.getOne(trackId));
        return "edit";
    }
    @PostMapping("tracks/{trackId}/edit")
    public String updateTrack(
            @PathVariable ("trackId") Long trackId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer release,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String submitter,
            @RequestParam(required = false) String urlposter,
            Model model
    ){
        Track track = trackRepository.findById(trackId).orElseThrow(IllegalStateException::new);
        track.setTitle(title);
        track.setUrlposter(urlposter);
        track.setRelease(release);
        track.setGenre(genre);
        track.setSubmitter(submitter);
        track.setAuthor(author);
        trackRepository.save(track);
        return "redirect:/tracks/"+trackId;
    }





}

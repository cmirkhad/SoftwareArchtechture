package com.example.music.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    private final TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @GetMapping("")
    public List<Track> getAllTrack(){
        return trackService.getAllTracks();
    }

    @PostMapping("")
    public void newTrack(@RequestBody @ModelAttribute Track track){

        trackService.addNewTrack(track);


    }
    @DeleteMapping("{trackId}")
    public void deleteTrack(@PathVariable ("trackId") Long trackId){
        trackService.deleteTrack(trackId);

    }
    @PutMapping("{trackId}")
    public void updateTrack(
            @PathVariable ("trackId") Long trackId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) int release,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String submitter,
            @RequestParam(required = false) String urlposter


    ){
        trackService.updateTrack(trackId, title, author, release, genre, submitter,urlposter);
    }





}

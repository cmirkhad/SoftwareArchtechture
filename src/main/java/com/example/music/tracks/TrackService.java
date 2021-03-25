package com.example.music.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Service
public class TrackService {
    private final TrackRepository trackRepository;
    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }
    public void addNewTrack(Track track){
        trackRepository.save(track);
    }
    public void deleteTrack(Long trackId){
        boolean exists = trackRepository.existsById(trackId);
        if(!exists) {
            throw new IllegalStateException("student with id "+ trackId+ "does not exist");
        }
        trackRepository.deleteById(trackId);

    }
    public void updateTrack(Long trackId, String title, String author, int release, String genre, String submitter, String urlposter){
        Track track = trackRepository.findById(trackId).
                orElseThrow(() -> new IllegalStateException(
                        "track with id "+ trackId+" does not exist"));
        if(title!=null && title.length()>0 && !Objects.equals(track.getTitle(), title)){
            track.setTitle(title);
        }
        if(author!=null && author.length()>0 && !Objects.equals(track.getAuthor(), author)){
            track.setAuthor(author);
        }
        if(release<= LocalDate.now().getYear() && !Objects.equals(track.getRelease(), release)){
            track.setRelease(release);
        }
        if(genre!=null && genre.length()>0 && !Objects.equals(track.getGenre(), genre)){
            track.setGenre(genre);
        }
        if(submitter!=null && submitter.length()>0 && !Objects.equals(track.getSubmitter(), submitter)){
            track.setSubmitter(submitter);
        }
        if(urlposter!=null && urlposter.length()>0 && !Objects.equals(track.getUrlposter(), urlposter)){
            track.setUrlposter(urlposter);
        }
    }




}

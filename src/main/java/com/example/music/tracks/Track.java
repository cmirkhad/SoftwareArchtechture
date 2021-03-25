package com.example.music.tracks;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table
public class Track {


    @Id
    @SequenceGenerator(
            name = "track_sequence",
            sequenceName = "track_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "track_sequence"
    )

    private Long id;

    private String title;

    private String author;
    private Integer release;

    private String genre;

    private String submitter;
    private String urlposter;

    public String getUrlposter() {
        return urlposter;
    }

    public void setUrlposter(String urlposter) {
        this.urlposter = urlposter;
    }

    public Track(Long id, @NonNull String title, String author, Integer release, String genre, @NonNull String submitter, String urlposter) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.release = release;
        this.genre = genre;
        this.submitter = submitter;
        this.urlposter = urlposter;
    }
    public Track(@NonNull String title, String author, Integer release, String genre, @NonNull String submitter, String urlposter) {
        this.title = title;
        this.author = author;
        this.release = release;
        this.genre = genre;
        this.submitter = submitter;
        this.urlposter = urlposter;
    }
    public Track(){

    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getRelease() {
        return release;
    }

    public void setRelease(Integer release) {
        this.release = release;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", release=" + release +
                ", genre='" + genre + '\'' +
                ", submitter='" + submitter + '\'' +
                ", urlposter='" + urlposter + '\'' +
                '}';
    }
}

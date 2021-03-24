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
    @NonNull
    private String title;

    private String author;
    @NonNull
    private int release;

    private String genre;
    @NonNull
    private String submitter;
    public Track(Long id, @NonNull String title, String author, int release, String genre, @NonNull String submitter) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.release = release;
        this.genre = genre;
        this.submitter = submitter;
    }
    public Track(@NonNull String title, String author, int release, String genre, @NonNull String submitter) {
        this.title = title;
        this.author = author;
        this.release = release;
        this.genre = genre;
        this.submitter = submitter;
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

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
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
                ", release='" + release + '\'' +
                ", genre='" + genre + '\'' +
                ", submitter='" + submitter + '\'' +
                '}';
    }
}

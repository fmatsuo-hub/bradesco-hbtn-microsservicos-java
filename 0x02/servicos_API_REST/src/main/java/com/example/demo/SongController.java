package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Bem-vindo ao serviço de músicas!";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @GetMapping(path = "/findSong/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Integer id) {
        Song s = songRepository.getSongById(id);
        if (s == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping("/addSong")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        songRepository.addSong(song);
        return new ResponseEntity<>(song, HttpStatus.CREATED);
    }

    @PutMapping("/updateSong")
    public ResponseEntity<Song> updadeSong(@RequestBody Song song) {
        if (song == null || song.getId() == null || songRepository.getSongById(song.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songRepository.updateSong(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @DeleteMapping("/removeSong")
    public ResponseEntity<Void> deleteSongById(@RequestBody Song song) {
        if (song == null || song.getId() == null || songRepository.getSongById(song.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songRepository.removeSong(song);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<Song>();

    public SongRepository() {
        list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        if (id == null) return null;
        for (Song s : list) {
            if (id.equals(s.getId())) {
                return s;
            }
        }
        return null;
    }

    public void addSong(Song s) {
        if (s == null) return;
        if (s.getId() == null) {
            int nextId = 1;
            for (Song song : list) {
                if (song.getId() != null && song.getId() >= nextId) {
                    nextId = song.getId() + 1;
                }
            }
            s.setId(nextId);
        }
        list.add(s);
    }

    public void updateSong(Song s) {
        if (s == null || s.getId() == null) return;
        for (int i = 0; i < list.size(); i++) {
            Song cur = list.get(i);
            if (s.getId().equals(cur.getId())) {
                list.set(i, s);
                return;
            }
        }
    }

    public void removeSong(Song s) {
        if (s == null || s.getId() == null) return;
        Song found = getSongById(s.getId());
        if (found != null) {
            list.remove(found);
        }
    }
}

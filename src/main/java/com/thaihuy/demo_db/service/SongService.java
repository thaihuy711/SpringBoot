package com.thaihuy.demo_db.service;

import com.thaihuy.demo_db.controller.MusicanForm;
import com.thaihuy.demo_db.controller.SongForm;
import com.thaihuy.demo_db.domain.Musican;
import com.thaihuy.demo_db.domain.Song;
import com.thaihuy.demo_db.model.SongModel;
import com.thaihuy.demo_db.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<SongModel> getAll() {
        return songRepository.findAll().stream().map(Song::toModel).collect(Collectors.toList());

    }
    public Song create(SongForm form) {

        Song s = new Song();
        s.setSongName(form.getSongName());
        Musican musican = new Musican(form.getMusicanId());
        s.setMusican(musican);
        return songRepository.save(s);
    }
    public void delete(BigInteger id) {
        songRepository.delete(id);
    }
}

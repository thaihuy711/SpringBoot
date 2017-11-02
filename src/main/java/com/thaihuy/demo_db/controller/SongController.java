package com.thaihuy.demo_db.controller;


import com.thaihuy.demo_db.domain.Song;
import com.thaihuy.demo_db.model.SongModel;
import com.thaihuy.demo_db.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }
    /**
     * GET ALL
     */
    @GetMapping()
    public List<SongModel>getALL(){
        return songService.getAll();
    }

    @PostMapping
    public Song create( @RequestBody SongForm form ){
        return songService.create(form);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id) {
        songService.delete(id);
    }
}

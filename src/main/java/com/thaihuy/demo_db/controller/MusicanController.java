package com.thaihuy.demo_db.controller;


import com.thaihuy.demo_db.domain.Musican;
import com.thaihuy.demo_db.domain.Song;
import com.thaihuy.demo_db.model.MusicanModel;
import com.thaihuy.demo_db.repository.MusicanRepository;
import com.thaihuy.demo_db.service.MusicanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/musicans")
public class MusicanController {
    private final MusicanService musicanService;

    @Autowired
    public MusicanController(MusicanService musicanService) {
        this.musicanService = musicanService;
    }

    //    @GetMapping()
//    public PagingObject<MusicanModel> getAllMusicans(@RequestParam(defaultValue = "0") Integer page,
//                                                     @RequestParam(defaultValue = "10") Integer size) {
//        return musicanService.getAllMusicans(page, size);
//    }
    @GetMapping()
    public PagingObject<MusicanModel> getAllMusicans(org.springframework.data.domain.Pageable pageable) {
        return musicanService.getAllMusicans(pageable);
    }

    @PostMapping
    public Musican create(@RequestBody MusicanForm form) {
        return musicanService.create(form);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody MusicanForm form, @PathVariable BigInteger id) {
        return musicanService.update(form, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable BigInteger id) {
        return musicanService.delete(id);
    }

    @GetMapping("/dataTest")
    public void insertDataTest() {
        musicanService.insertDataTest();
    }


}

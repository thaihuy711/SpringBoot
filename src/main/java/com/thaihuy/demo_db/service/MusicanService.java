package com.thaihuy.demo_db.service;

import com.thaihuy.demo_db.controller.MusicanForm;
import com.thaihuy.demo_db.controller.PagingObject;
import com.thaihuy.demo_db.controller.SongForm;
import com.thaihuy.demo_db.domain.Musican;
import com.thaihuy.demo_db.domain.Song;
import com.thaihuy.demo_db.model.MusicanModel;
import com.thaihuy.demo_db.repository.MusicanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MusicanService {
    private final MusicanRepository musicanRepository;

    @Autowired
    public MusicanService(MusicanRepository musicanRepository) {
        this.musicanRepository = musicanRepository;
    }

//    public PagingObject<MusicanModel> getAllMusicans(Integer page, Integer size) {
//        log.info("Paging size: " + size, "/Page:" + page);
//        if (size > 500) size = 10;
//        PageRequest pageRequest = new PageRequest(page, size);
//        PagingObject<MusicanModel> rs = new PagingObject<>();
//        Page<Musican> musicansPage = musicanRepository.findAll(pageRequest);
//        rs.setTotal(musicansPage.getTotalElements());
//        rs.setTotalPage(musicansPage.getTotalPages());
//        rs.setData(musicansPage.getContent().stream().map(Musican::toModel).collect(Collectors.toList()));
//        return rs;
//
//        //musican -> musican.toModel()
//    }

    public PagingObject<MusicanModel> getAllMusicans(Pageable pageable) {
        log.info("Paging: " + pageable);
        if (pageable.getPageSize() > 500) throw new RuntimeException();

        PagingObject<MusicanModel> rs = new PagingObject<>();

        Page<Musican> musicansPage = musicanRepository.findAll(pageable);
        rs.setTotal(musicansPage.getTotalElements());
        rs.setTotalPage(musicansPage.getTotalPages());
        rs.setData(musicansPage.getContent().stream().map(Musican::toModel).collect(Collectors.toList()));
        return rs;

        //musican -> musican.toModel()
    }


    public Musican create(MusicanForm form) {
        log.error("Create form: " + form);
        Musican m = new Musican();
        m.setMusicanName(form.getMusicanName());
        return musicanRepository.save(m);
    }

    public void insertDataTest() {
        for (long i = 0; i < 1000000; i++) {
            Musican s = new Musican();
            s.setMusicanName("Musican " + i);
            musicanRepository.save(s);
        }
    }

    public String update(MusicanForm form, BigInteger id) {
        // Tim doi tuong can update
        Musican msc = musicanRepository.findOne(id);

        if (form.getMusicanName() != null) {
            msc.setMusicanName(form.getMusicanName());
        }

        // Chuyen song Form sang Song domain
        if (form.getSongFormList() != null) {
            List<SongForm> songFormList = form.getSongFormList();
            msc.getSongs().clear();

            for (SongForm songForm : songFormList) {
                Song song = new Song();
                song.setSongName(songForm.getSongName());
                song.setMusican(msc);
                msc.getSongs().add(song);
            }
        } else {
            System.out.printf("abcd");
        }

        musicanRepository.save(msc);
        return "Updated!";
    }

    public String delete(BigInteger id) {
        musicanRepository.delete(id);
        return "Deleted!";
    }


}

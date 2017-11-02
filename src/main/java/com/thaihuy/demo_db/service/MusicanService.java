package com.thaihuy.demo_db.service;

import com.thaihuy.demo_db.controller.MusicanForm;
import com.thaihuy.demo_db.controller.SongForm;
import com.thaihuy.demo_db.domain.Musican;
import com.thaihuy.demo_db.domain.Song;
import com.thaihuy.demo_db.model.MusicanModel;
import com.thaihuy.demo_db.repository.MusicanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MusicanService {
    private final MusicanRepository musicanRepository;

    @Autowired
    public MusicanService(MusicanRepository musicanRepository) {
        this.musicanRepository = musicanRepository;
    }

    public List<MusicanModel> getAll() {
        return musicanRepository.findAll().stream().map(Musican::toModel).collect(Collectors.toList());

        //musican -> musican.toModel()
    }

    public Musican create(MusicanForm form) {
        Musican m = new Musican();
        m.setMusicanName(form.getMusicanName());
        return musicanRepository.save(m);
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

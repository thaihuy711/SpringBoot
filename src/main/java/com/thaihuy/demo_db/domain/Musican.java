package com.thaihuy.demo_db.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thaihuy.demo_db.model.MusicanModel;
import com.thaihuy.demo_db.model.SongModel;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "musican")
public class Musican {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger musicanId;

    @Column(name = "musican_name")
    private String musicanName;

    @OneToMany(mappedBy = "musican", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonBackReference
    private List<Song> songs;

    public Musican() {

    }

    public Musican(BigInteger musicanId) {
        this.musicanId = musicanId;
    }

    public MusicanModel toModel() {
        MusicanModel ms = new MusicanModel();
        ms.setMusicanId(musicanId);
        ms.setMusicanName(musicanName);

        for (Song song : songs) {
            ms.getSongModel().add(song.toModel());
        }
        return ms;
    }

}

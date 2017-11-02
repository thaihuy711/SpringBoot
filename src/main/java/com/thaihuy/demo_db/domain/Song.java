package com.thaihuy.demo_db.domain;

import com.thaihuy.demo_db.model.SongModel;
import lombok.Data;

import javax.persistence.*;

import java.math.BigInteger;


@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger songId;

    @Column(name = "song_name")
    private String songName;

    @ManyToOne
    @JoinColumn(name = "musican_id")
    private Musican musican;

    public SongModel toModel() {
        SongModel ss = new SongModel();
        ss.setSongId(songId);
        ss.setSongName(songName);

        return ss;
    }
}

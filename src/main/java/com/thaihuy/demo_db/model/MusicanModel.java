package com.thaihuy.demo_db.model;

import com.thaihuy.demo_db.domain.Song;
import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class MusicanModel {

    private BigInteger musicanId;
    private String musicanName;
    private List<SongModel> songModel;

    public MusicanModel() {
        songModel = new ArrayList<>();
    }

    public MusicanModel(BigInteger musicanId, String musicanName) {
        this.musicanId = musicanId;
        this.musicanName = musicanName;
    }
}

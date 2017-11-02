package com.thaihuy.demo_db.model;

import com.thaihuy.demo_db.domain.Song;
import lombok.Data;

import java.math.BigInteger;
@Data
public class SongModel {

    private BigInteger songId;
    private String songName;

}

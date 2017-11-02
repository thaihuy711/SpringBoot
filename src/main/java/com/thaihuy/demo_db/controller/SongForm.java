package com.thaihuy.demo_db.controller;

import lombok.Data;

import java.math.BigInteger;

@Data
public class SongForm {
    private BigInteger musicanId;
    private String songName;
}

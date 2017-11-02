package com.thaihuy.demo_db.controller;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;
@Data
public class MusicanForm {
    private BigInteger id;
    private String musicanName;
    private List<SongForm> songFormList;

}

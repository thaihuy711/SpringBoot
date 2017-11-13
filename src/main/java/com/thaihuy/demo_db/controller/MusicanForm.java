package com.thaihuy.demo_db.controller;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigInteger;
import java.util.List;
@Data
public class MusicanForm {

    @NotBlank
    private BigInteger id;
    @NotEmpty
    private String musicanName;
    private List<SongForm> songFormList;

}

package com.thaihuy.demo_db.repository;

import com.thaihuy.demo_db.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.math.BigInteger;

public interface SongRepository extends JpaRepository<Song, BigInteger> {

}

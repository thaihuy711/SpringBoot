package com.thaihuy.demo_db.repository;

import com.thaihuy.demo_db.domain.Musican;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.math.BigInteger;

public interface MusicanRepository extends JpaRepository<Musican,BigInteger> {
}

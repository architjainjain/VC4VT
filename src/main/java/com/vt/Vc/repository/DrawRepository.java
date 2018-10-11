package com.vt.Vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.Vc.model.Draw;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Long> {

}

package com.vt.Vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.Vc.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}

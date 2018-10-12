package com.vt.Vc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Long> {
	
	@Query("SELECT d FROM Draw d WHERE d.group = :Group")
	public List<Draw> findDrawByGroup(@Param("Group") Group Group);

}

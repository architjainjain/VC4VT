package com.vt.Vc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vt.Vc.enumerate.BidStatus;
import com.vt.Vc.model.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
	
	@Query("SELECT u FROM Bid u WHERE u.status = :status")
	public List<Bid> findByStatus(@Param("status")BidStatus initial);
	
	
	@Query("SELECT u FROM Bid u WHERE u.bidID = :ID ")
	public List<Bid> findByDrawId(@Param("ID") Long Id);

}
package com.vt.Vc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vt.Vc.enumerate.BidStatus;
import com.vt.Vc.model.Bid;
import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
	
	@Query("SELECT u FROM Bid u WHERE u.status = :status")
	public List<Bid> findByStatus(@Param("status")BidStatus initial);
	
	
	@Query("SELECT u FROM Bid u WHERE u.draw = :ID ")
	public List<Bid> findByDrawId(@Param("ID") Draw draw);
	
	@Query("SELECT b FROM Bid b JOIN Draw d ON d.drawID = b.draw AND b.draw = :DrawId AND b.status = :status ")
	public List<Bid> getBidForTheGroupByStatus(@Param("DrawId") Draw draw, @Param("status")BidStatus status);

}

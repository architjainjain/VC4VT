package com.vt.Vc.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vt.Vc.enumerate.BidStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="BIDS")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Bid implements Serializable {
	
	
	private static final long serialVersionUID = 2064165685360785358L;


	@Id
	@GeneratedValue
	@Column(name="BID_ID")
	private long bidID;
	
	
	@Column(name="BID_AMOUNT")
	private double bidAmount;
	
	@ManyToOne
	@JoinColumn(name="DRAW_ID", nullable=false)
	private Draw draw;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false)
	private Member bidder;
	
	@Column(name="STATUS", nullable=false)
	@Enumerated(EnumType.STRING)
	@Builder.Default 
	private BidStatus status=BidStatus.CURRENT;
	
	@Column(name="BID_TIME")
	@Builder.Default
	private LocalDateTime BidTime=LocalDateTime.now();
	
	

}

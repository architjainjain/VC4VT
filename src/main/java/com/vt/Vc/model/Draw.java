package com.vt.Vc.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="DRAW")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Draw {

	@Id
	@GeneratedValue
	@Column(name="DRAW_ID")
	private Long drawID;
	
	@Column(name="DRAW_DATE")
	private Date drawDate;
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID", nullable=false)
	private Group group;
	
	
	@Column(name="START_AMOUNT")
	private double startAmount;
	
	@Column(name="FINAL_AMOUNT")
	private double endAmount;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false)
	private Member member;
	
	@OneToMany(mappedBy="draw")
	private Set<Bid> bids;
	
	@Column(name="DRAW_NUMBER", nullable=false)
	private int drawNumber;
	
	
}

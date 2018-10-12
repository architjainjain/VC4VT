package com.vt.Vc.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vt.Vc.enumerate.DrawStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="DRAW")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Draw {

	@Id
	@GeneratedValue
	@Column(name="DRAW_ID")
	private Long drawID;
	
	@Column(name="DRAW_DATE")
	@Builder.Default
	private LocalDate drawDate=LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID", nullable=false)
	private Group group;
	
	
	@Column(name="START_AMOUNT")
	private double startAmount;
	
	@Column(name="FINAL_AMOUNT")
	private double endAmount;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;
	
	@OneToMany(mappedBy="draw")
	private Set<Bid> bids;
	
	@Column(name="DRAW_NUMBER", nullable=false)
	private int drawNumber;
	
	@Column(name="DRAW_STATUS", nullable=false)
	@Enumerated(EnumType.STRING)
	private DrawStatus status;
	
	
}

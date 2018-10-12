package com.vt.Vc.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vt.Vc.enumerate.groupStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VCGROUP")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
	
	@Id
	@GeneratedValue
	@Column(name = "GROUP_ID")
	private long groupID;
	
	@Column(name="GROUP_NAME")
	private String groupName;
	
	@Column(name="GROUP_DESC")
	private String description;
	
	@Column(name="INTEREST", nullable=false)
	private double interesetRate;
	
	@Column(name="START_DATE")
	private LocalDate groupStartDate;
	
	@Column(name="NUMBER_OF_MEMBER")
	@Builder.Default
	private int noOfMembers=12;
	
	@Column(name="END_DATE")
	private LocalDate groupEndDate;
	
	@Column(name="DRAW_DONE_COUNT")
	private int numberofDrawDone;
	
	@Column(name="GROUP_STATUS")
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private groupStatus status= groupStatus.NEW;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "VCGROUP_MEMBER", joinColumns = { @JoinColumn(name = "GROUP_ID") }, inverseJoinColumns = { @JoinColumn(name = "MEMBER_ID") })
	private Set<Member> memberslist;
	
	@OneToMany(mappedBy="group")
	private Set<Draw> drawList;

}

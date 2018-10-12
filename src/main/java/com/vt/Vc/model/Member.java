package com.vt.Vc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vt.Vc.enumerate.MemberStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable{
	
	
	private static final long serialVersionUID = -3879597615572979808L;

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID", unique=true)
	private long memberId;


	@Column(name = "MEMBER_NAME", nullable = false, length = 100, unique=true)
	private  String memberName;
	
	@Column(name = "MEMBER_MOBILE", nullable = false, length = 10, unique=true)
	private String membermobile;


	@ManyToMany(mappedBy="memberslist")
    private List<Group> groups = new ArrayList<>();
	
	@OneToMany(mappedBy="member")
	private Set<Draw> drawList;
	
	@OneToMany(mappedBy="bidder")
	private Set<Bid> BidList;
	
	@Column(name="MEMBER_STATUS")
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private MemberStatus memberStatus=MemberStatus.NEW;

}

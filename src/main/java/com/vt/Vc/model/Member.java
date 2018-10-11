package com.vt.Vc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vt.Vc.enumerate.MemberStatus;

@Entity
@Table(name = "MEMBER")
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
	private MemberStatus memberStatus;
	

	

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMembermobile() {
		return membermobile;
	}

	public void setMembermobile(String membermobile) {
		this.membermobile = membermobile;
	}

	
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Set<Draw> getDrawList() {
		return drawList;
	}

	public void setDrawList(Set<Draw> drawList) {
		this.drawList = drawList;
	}

	public Set<Bid> getBidList() {
		return BidList;
	}

	public void setBidList(Set<Bid> bidList) {
		BidList = bidList;
	}

	public MemberStatus getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Member() {
		super();
	}

	public Member(String memberName, String membermobile, List<Group> groups, Set<Draw> drawList,
			Set<Bid> bidList, MemberStatus memberStatus) {
		super();
		this.memberName = memberName;
		this.membermobile = membermobile;
		this.groups = groups;
		this.drawList = drawList;
		BidList = bidList;
		this.memberStatus = memberStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + (int) (memberId ^ (memberId >>> 32));
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberStatus == null) ? 0 : memberStatus.hashCode());
		result = prime * result + ((membermobile == null) ? 0 : membermobile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (memberId != other.memberId)
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberStatus != other.memberStatus)
			return false;
		if (membermobile == null) {
			if (other.membermobile != null)
				return false;
		} else if (!membermobile.equals(other.membermobile))
			return false;
		return true;
	}
	

	


}

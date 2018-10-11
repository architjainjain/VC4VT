package com.vt.Vc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vt.Vc.enumerate.groupStatus;

@Entity
@Table(name = "VCGROUP")
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
	private Date groupStartDate;
	
	@Column(name="NUMBER_OF_MEMBER")
	private int noOfMembers;
	
	@Column(name="END_DATE")
	private Date groupEndDate;
	
	@Column(name="DRAW_DONE_COUNT")
	private int numberofDrawDone;
	
	@Column(name="GROUP_STATUS")
	private groupStatus status;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "VCGROUP_MEMBER", joinColumns = { @JoinColumn(name = "GROUP_ID") }, inverseJoinColumns = { @JoinColumn(name = "MEMBER_ID") })
	private Set<Member> memberslist= new HashSet<>(0);
	
	@OneToMany(mappedBy="group")
	private Set<Draw> drawList;

	public Group( String groupName, String description, double interesetRate, Date groupStartDate,
			int noOfMembers, Date groupEndDate, int numberofDrawDone, groupStatus status, Set<Member> memberslist,
			Set<Draw> drawList) {
		super();
		this.groupName = groupName;
		this.description = description;
		this.interesetRate = interesetRate;
		this.groupStartDate = groupStartDate;
		this.noOfMembers = noOfMembers;
		this.groupEndDate = groupEndDate;
		this.numberofDrawDone = numberofDrawDone;
		this.status = status;
		this.memberslist = memberslist;
		this.drawList = drawList;
	}

	public Group() {
		super();
	}

	public long getGroupID() {
		return groupID;
	}

	public void setGroupID(long groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getInteresetRate() {
		return interesetRate;
	}

	public void setInteresetRate(double interesetRate) {
		this.interesetRate = interesetRate;
	}

	public Date getGroupStartDate() {
		return groupStartDate;
	}

	public void setGroupStartDate(Date groupStartDate) {
		this.groupStartDate = groupStartDate;
	}

	public int getNoOfMembers() {
		return noOfMembers;
	}

	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}

	public Date getGroupEndDate() {
		return groupEndDate;
	}

	public void setGroupEndDate(Date groupEndDate) {
		this.groupEndDate = groupEndDate;
	}

	public int getNumberofDrawDone() {
		return numberofDrawDone;
	}

	public void setNumberofDrawDone(int numberofDrawDone) {
		this.numberofDrawDone = numberofDrawDone;
	}

	public groupStatus getStatus() {
		return status;
	}

	public void setStatus(groupStatus status) {
		this.status = status;
	}

	
	public Set<Member> getMemberslist() {
		return memberslist;
	}

	public void setMemberslist(Set<Member> memberslist) {
		this.memberslist = memberslist;
	}

	public Set<Draw> getDrawList() {
		return drawList;
	}

	public void setDrawList(Set<Draw> drawList) {
		this.drawList = drawList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((drawList == null) ? 0 : drawList.hashCode());
		result = prime * result + ((groupEndDate == null) ? 0 : groupEndDate.hashCode());
		result = prime * result + (int) (groupID ^ (groupID >>> 32));
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((groupStartDate == null) ? 0 : groupStartDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(interesetRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((memberslist == null) ? 0 : memberslist.hashCode());
		result = prime * result + noOfMembers;
		result = prime * result + numberofDrawDone;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Group other = (Group) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (drawList == null) {
			if (other.drawList != null)
				return false;
		} else if (!drawList.equals(other.drawList))
			return false;
		if (groupEndDate == null) {
			if (other.groupEndDate != null)
				return false;
		} else if (!groupEndDate.equals(other.groupEndDate))
			return false;
		if (groupID != other.groupID)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (groupStartDate == null) {
			if (other.groupStartDate != null)
				return false;
		} else if (!groupStartDate.equals(other.groupStartDate))
			return false;
		if (Double.doubleToLongBits(interesetRate) != Double.doubleToLongBits(other.interesetRate))
			return false;
		if (memberslist == null) {
			if (other.memberslist != null)
				return false;
		} else if (!memberslist.equals(other.memberslist))
			return false;
		if (noOfMembers != other.noOfMembers)
			return false;
		if (numberofDrawDone != other.numberofDrawDone)
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	
	
	
	
	
	

}

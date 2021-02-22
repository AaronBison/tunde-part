package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BranchUpdateRequest {

	@NotNull
    @NotEmpty
	private String id;
	
	@NotNull
    @NotEmpty
	private String branchName;
	
	@NotNull
    @NotEmpty
	private String coordinatorName;
	
	@NotNull
    @NotEmpty
	@Pattern(regexp="^(.+)@(.+)$")
	private String coordinatorEmail;
	
	@NotNull
    @NotEmpty
	private String roomNumber;
	
	@NotNull
    @NotEmpty
	private String link;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public String getCoordinatorEmail() {
		return coordinatorEmail;
	}

	public void setCoordinatorEmail(String coordinatorEmail) {
		this.coordinatorEmail = coordinatorEmail;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}

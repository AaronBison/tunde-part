package com.Sapi3DTourMongo.Sapi3DTourMongo.respons;

public class GetBranchNameResponse {
	
	private String id;
	
	private String branchName;
	
	private String coordinatorName;
	
	private String coordinatorEmail;
	
	private String roomNumber;
	
	private String link;
	
	public GetBranchNameResponse (String id, String branchName, String coordinatorName, String coordinatorEmail, String roomNumber, String link)
	{
		this.id = id;
		this.branchName = branchName;
		this.coordinatorEmail = coordinatorEmail;
		this.coordinatorName = coordinatorName;
		this.roomNumber = roomNumber;
		this.link = link;
	}

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

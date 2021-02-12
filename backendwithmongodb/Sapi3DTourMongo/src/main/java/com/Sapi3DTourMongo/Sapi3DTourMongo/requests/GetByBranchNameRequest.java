package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GetByBranchNameRequest {
	
	@NotNull
    @NotEmpty
	private String branchName;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}

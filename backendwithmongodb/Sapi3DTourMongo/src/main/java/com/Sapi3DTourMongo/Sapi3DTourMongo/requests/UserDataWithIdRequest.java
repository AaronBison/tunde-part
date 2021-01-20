package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;

public class UserDataWithIdRequest {
	
	@NotBlank
	@NotEmpty
	private ObjectId _id;

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
	}
}

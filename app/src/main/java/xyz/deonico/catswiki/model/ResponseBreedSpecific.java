package xyz.deonico.catswiki.model;

import com.google.gson.annotations.SerializedName;

public class ResponseBreedSpecific {

	@SerializedName("code")
	private int code;

	@SerializedName("breed")
	private ResponseBreed breed;

	@SerializedName("errors")
	private Object errors;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setBreed(ResponseBreed breed){
		this.breed = breed;
	}

	public ResponseBreed getBreed(){
		return breed;
	}

	public void setErrors(Object errors){
		this.errors = errors;
	}

	public Object getErrors(){
		return errors;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseBreedSpecific{" +
			"code = '" + code + '\'' + 
			",breed = '" + breed + '\'' + 
			",errors = '" + errors + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
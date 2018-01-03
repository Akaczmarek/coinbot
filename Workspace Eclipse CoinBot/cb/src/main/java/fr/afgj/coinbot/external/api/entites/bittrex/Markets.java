package fr.afgj.coinbot.external.api.entites.bittrex;

import java.util.ArrayList;
import java.util.List;

public class Markets {

	private boolean success;
	private String message;
	private List<Results> listResult;

	public Markets() {
		this(false);
	}
	
	public Markets(boolean success) {
		this(success, "");
	}
	
	public Markets(boolean success, String message) {
		this(success, message, null);
	}
	
	public Markets(boolean success, String message, List<Results> listResult) {
		super();
		this.setSuccess(success);
		this.setMessage(message);
		this.setListResult(listResult);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addResult(Results result) {
		if(getListResult() == null) {
			listResult = new ArrayList<>();
			listResult.add(result);
		} else {
			this.listResult.add(result);
		}
	}

	public List<Results> getListResult() {
		return listResult;
	}

	public void setListResult(List<Results> listResult) {
		this.listResult = listResult;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Market [success=");
		builder.append(success);
		builder.append(", message=");
		builder.append(message);
		builder.append(", result=");
		builder.append(listResult);
		builder.append("]");
		return builder.toString();
	}

}

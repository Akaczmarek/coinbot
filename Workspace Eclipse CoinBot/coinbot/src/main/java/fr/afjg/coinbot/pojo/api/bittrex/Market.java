package fr.afjg.coinbot.pojo.api.bittrex;

import java.util.ArrayList;
import java.util.List;

public class Market {

	private boolean success;
	private String message;
	private List<Result> listResult;

	public Market() {
		this(false);
	}
	
	public Market(boolean success) {
		this(success, "");
	}
	
	public Market(boolean success, String message) {
		this(success, message, null);
	}
	
	public Market(boolean success, String message, List<Result> listResult) {
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
	
	public void addResult(Result result) {
		if(getListResult() == null) {
			listResult = new ArrayList<>();
			listResult.add(result);
		} else {
			this.listResult.add(result);
		}
	}

	public List<Result> getListResult() {
		return listResult;
	}

	public void setListResult(List<Result> listResult) {
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

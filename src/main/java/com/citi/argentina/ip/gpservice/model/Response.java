package com.citi.argentina.ip.gpservice.model;

import java.util.List;

import lombok.Data;

/*@Data*/
public class Response {

	List<Object> data;
	List<Object> error;

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public List<Object> getError() {
		return error;
	}

	public void setError(List<Object> error) {
		this.error = error;
	}

	public Response() {
	}

	public Response(List<Object> data, List<Object> error) {
		this.data = data;
		this.error = error;
	}
}

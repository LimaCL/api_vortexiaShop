package com.example.Vortexia.Shop.response;
import org.springframework.http.HttpStatus;

public class Output<T> {

	private T result;
	private HttpStatus status;
	
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}

package com.springboot.angular.controller.exception.handler;

import java.io.Serializable;

public class ErroPadrao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private long timestamp;
	
	public ErroPadrao(Integer status, String msg, long timestamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}


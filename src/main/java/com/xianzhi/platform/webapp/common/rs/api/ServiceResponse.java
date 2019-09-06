package com.xianzhi.platform.webapp.common.rs.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.common.utility.ServiceResponseUtility;

import java.io.Serializable;

public class ServiceResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("result_code")
	private String resultCode;

	@JsonProperty("result_message")
	private String resultMessage;

	// 为每一个错误产生一个临时近似唯一的ID，这个ID会记录到日志里面，方便错误定位
	@JsonProperty("error_id")
	private String errorId;

	public ServiceResponse() {
		resultCode = ServiceResponseUtility.CODE_SUCCESS;
		resultMessage = "成功";
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	};

}

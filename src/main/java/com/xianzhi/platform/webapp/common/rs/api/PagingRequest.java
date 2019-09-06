package com.xianzhi.platform.webapp.common.rs.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagingRequest {
	
	private boolean paged;

	@JsonProperty("page_number")
	private int pageNumber;
	@JsonProperty("page_size")
	private int pageSize;
	
	public PagingRequest() {
		this.paged = true;
		this.pageNumber = 1;
		this.pageSize = 10;
	}
	
	public boolean isPaged() {
		return paged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}

	public int getPageNumber() {
        return pageNumber;
    }
    
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
}

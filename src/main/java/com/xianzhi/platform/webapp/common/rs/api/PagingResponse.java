package com.xianzhi.platform.webapp.common.rs.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.common.model.PagingResult;

public class PagingResponse extends ServiceResponse {
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("page_number")
    private int pageNumber;
    @JsonProperty("record_number")
    private int recordNumber;
    @JsonProperty("total_page")
    private int totalPage;
    
    public int getPageNumber() {
        return pageNumber;
    }
    
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    
    public int getRecordNumber() {
        return recordNumber;
    }
    
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public void setPagingResult(PagingResult result) {
        if (result != null) {
            setPageNumber(result.getPageNumber());
            setRecordNumber(result.getRecordNumber());
            setTotalPage(result.getTotalPage());
        }
    }
}  

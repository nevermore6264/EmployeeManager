package com.fpoly.record.action;

import java.util.Map;

import com.fpoly.record.service.RecordService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import vn.poly.sof305.group1.record.dto.RecordDto;
import vn.poly.sof305.group1.record.service.RecordService;
@ResultPath("/views/record")
@InterceptorRef(value = "loginStack")
public class RecordRemoveAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecordService recordService;
	private RecordDto recordDto;
	private Long id;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	@Action(value = "removeRecord", results= {@Result(name = SUCCESS, location = "record", type="redirectAction")})
	public String removeRecord() {
		
		recordService.remove(id);
		session.put("sessionMessageDto", getText("message.delete.success"));
			return SUCCESS;		
	}
	public RecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	public RecordDto getRecordDto() {
		return recordDto;
	}
	public void setRecordDto(RecordDto recordDto) {
		this.recordDto = recordDto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

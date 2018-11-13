package com.fpoly.record.action;

import java.util.List;
import java.util.Map;

import com.fpoly.record.service.RecordService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.fpoly.record.dto.ReEmployeeDto;
import com.fpoly.record.dto.RecordDto;
import com.fpoly.record.service.RecordService;

@ResultPath("/views/record")
@InterceptorRef(value = "loginStack")
public class RecordUpdateAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecordService recordService;
	private List<ReEmployeeDto> listEmployee;
	private RecordDto recordDto;
	private Long id;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	@Action(value = "inputUpdateRecord", results= {@Result(name = INPUT, location = "updateRecord.jsp")})
	public String input() {
		recordDto = recordService.selectId(id);
		listEmployee = recordService.employees(null);
		return INPUT;
	}
	
	@Action(value = "updateRecord", results= {@Result(name = SUCCESS, location = "record", type="redirectAction"),
											@Result(name = INPUT, location = "updateRecord.jsp")})
	public String updateRecord() {
		recordDto.setId(id);
		listEmployee = recordService.employees(null);
		if (recordService.update(recordDto)) {
			session.put("sessionMessageDto", getText("message.update.success"));
			return SUCCESS;
		}
		return INPUT;
	}

	public RecordService getRecordService() {
		return recordService;
	}

	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}



	public List<ReEmployeeDto> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<ReEmployeeDto> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public RecordDto getRecordDto() {
		return recordDto;
	}

	public void setRecordDto(RecordDto recordDto) {
		this.recordDto = recordDto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}

	

}

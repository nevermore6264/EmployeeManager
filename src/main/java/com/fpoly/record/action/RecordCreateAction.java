package com.fpoly.record.action;

import java.util.List;
import java.util.Map;

import com.fpoly.record.form.RecordCreateForm;
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
import com.fpoly.record.form.RecordCreateForm;
import com.fpoly.record.service.RecordService;

@ResultPath("/views/record/")
@InterceptorRef(value = "loginStack")
public class RecordCreateAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecordDto recordDto;
	private RecordService recordService;
	private RecordCreateForm recordCreateForm;
	private List<ReEmployeeDto> reEmployeeDto;
	private List<RecordCreateForm> listRecordCreateForm;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	@Action(value = "inputCreateRecord", results= {@Result(name = INPUT, location = "createRecord.jsp")})
	public String input() throws Exception {
		reEmployeeDto = recordService.employees(null);
		return INPUT;
	}
	
	
	@Action(value = "createRecord", results= {@Result(name = SUCCESS, location = "record", type="redirectAction"),
												@Result(name = INPUT, location = "createRecord.jsp")})
	public String create() {
		RecordDto recordDto = new RecordDto();
		recordDto.setId(recordCreateForm.getId());
		recordDto.setIdStaff(recordCreateForm.getIdStaff());
		recordDto.setType(recordCreateForm.isType());
		recordDto.setDate(recordCreateForm.getDate());
		recordDto.setReason(recordCreateForm.getReason());
		if (recordService.create(recordDto)) {
			session.put("sessionMessageDto", getText("message.create.success"));
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void validate() {
		reEmployeeDto = recordService.employees(null);
		if(recordCreateForm.getReason().isEmpty()) {
			addFieldError("recordCreateForm.reason", getText("record.reason.required"));
		}
		if(recordCreateForm.getDate().isEmpty()) {
			addFieldError("recordCreateForm.date", getText("record.reason.required"));
		}
	}

	public RecordDto getRecordDto() {
		return recordDto;
	}

	public void setRecordDto(RecordDto recordDto) {
		this.recordDto = recordDto;
	}

	public RecordService getRecordService() {
		return recordService;
	}

	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}

	public RecordCreateForm getRecordCreateForm() {
		return recordCreateForm;
	}

	public void setRecordCreateForm(RecordCreateForm recordCreateForm) {
		this.recordCreateForm = recordCreateForm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ReEmployeeDto> getReEmployeeDto() {
		return reEmployeeDto;
	}

	public void setReEmployeeDto(List<ReEmployeeDto> reEmployeeDto) {
		this.reEmployeeDto = reEmployeeDto;
	}

	public List<RecordCreateForm> getListRecordCreateForm() {
		return listRecordCreateForm;
	}

	public void setListRecordCreateForm(List<RecordCreateForm> listRecordCreateForm) {
		this.listRecordCreateForm = listRecordCreateForm;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}




	
}

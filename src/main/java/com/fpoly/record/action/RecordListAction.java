package com.fpoly.record.action;

import java.util.List;

import com.fpoly.common.dto.ListDataDto;
import com.fpoly.common.dto.ListPagingDto;
import com.fpoly.common.utils.DataTransformUtil;
import com.fpoly.record.form.RecordSearchForm;
import com.fpoly.record.service.RecordService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import vn.poly.sof305.group1.common.dto.ListDataDto;
import vn.poly.sof305.group1.common.dto.ListPagingDto;

import vn.poly.sof305.group1.common.utils.DataTransformUtil;
import vn.poly.sof305.group1.record.dto.ReEmployeeDto;
import vn.poly.sof305.group1.record.dto.RecordDto;
import vn.poly.sof305.group1.record.form.RecordSearchForm;
import vn.poly.sof305.group1.record.service.RecordService;

@ResultPath("/views/record")
@InterceptorRef(value = "loginStack")
public class RecordListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RecordDto> listRecord;
	private RecordService recordService;
	private RecordDto recordDto;
	private com.fpoly.common.dto.ListDataDto<RecordDto> ListDataDto = new ListDataDto<>();
	private ListPagingDto pagination;
	private List<ReEmployeeDto> reEmployee;
	private Long idStaff;
	private boolean type;
	private Long pn;

	@Action(value = "record", results = { @Result(name = SUCCESS, location = "listRecord.jsp") })
	public String input() {
		RecordDto recordDto = new RecordDto();
		RecordSearchForm recordSearchForm = (RecordSearchForm) DataTransformUtil.transform(recordDto,
				RecordSearchForm.class);
		recordSearchForm.setIdStaff(idStaff);
		recordSearchForm.setType(type);

		if (pn != null) {
			ListDataDto = recordService.getList(idStaff, type, pn);
		} else
			ListDataDto = recordService.getList(idStaff, type, pn = 1L);
		listRecord = ListDataDto.getList();
		pagination = ListDataDto.getPaging();
		reEmployee = recordService.employees(null);
		return SUCCESS;
	}

	public List<RecordDto> getListRecord() {
		return listRecord;
	}

	public void setListRecord(List<RecordDto> listRecord) {
		this.listRecord = listRecord;
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

	public ListDataDto<RecordDto> getListDataDto() {
		return ListDataDto;
	}

	public void setListDataDto(ListDataDto<RecordDto> listDataDto) {
		ListDataDto = listDataDto;
	}

	public ListPagingDto getPagination() {
		return pagination;
	}

	public void setPagination(ListPagingDto pagination) {
		this.pagination = pagination;
	}

	public List<ReEmployeeDto> getReEmployee() {
		return reEmployee;
	}

	public void setReEmployee(List<ReEmployeeDto> reEmployee) {
		this.reEmployee = reEmployee;
	}

	public Long getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(Long idStaff) {
		this.idStaff = idStaff;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public Long getPn() {
		return pn;
	}

	public void setPn(Long pn) {
		this.pn = pn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

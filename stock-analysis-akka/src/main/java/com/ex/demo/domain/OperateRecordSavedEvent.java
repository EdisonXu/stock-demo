package com.ex.demo.domain;

import java.io.Serializable;

/**
 * @author edison
 * On 2018/8/9 9:49
 */
public class OperateRecordSavedEvent implements Serializable {

	private static final long serialVersionUID = 30863719847313231L;

	private OperateRecord operateRecord;

	public OperateRecordSavedEvent() {
	}

	public OperateRecordSavedEvent(OperateRecord operateRecord) {
		this.operateRecord = operateRecord;
	}

	public OperateRecord getOperateRecord() {
		return operateRecord;
	}

	public void setOperateRecord(OperateRecord operateRecord) {
		this.operateRecord = operateRecord;
	}
}

package com.ex.demo.sa.controller;

import com.ex.demo.sa.domain.OperateRecord;
import com.ex.demo.sa.domain.OperateRecordSavedEvent;
import com.ex.demo.sa.mapper.OperateRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author edison
 * On 2018/8/8 16:52
 */
@RestController
@RequestMapping("op")
@Transactional
public class OperateRecordController {

	@Autowired
	private OperateRecordMapper operateRecordMapper;
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@PostMapping
	public void insert(@RequestBody OperateRecord record){
		operateRecordMapper.insert(record);
		eventPublisher.publishEvent(new OperateRecordSavedEvent(record));
	}
}

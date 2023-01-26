package com.gsupl.mapper;

import com.gsupl.entity.Send;

import java.util.List;

public interface SendMapper {

	int create(Send send);

	int delete(Integer id);

	int update(Send send);

	List<Send> query(Send send);

	Send detail(Integer id);

	int count(Send send);

	 int updateStatus(Send send);

	 int updateSelective(Send send);
}

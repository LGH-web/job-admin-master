package com.gsupl.mapper;

import com.gsupl.entity.Intention;

import java.util.List;

public interface IntentionMapper {

	int create(Intention intention);

	int delete(Integer id);

	int update(Intention intention);

	List<Intention> query(Intention intention);

	Intention detail(Integer id);

	int count(Intention intention);
}

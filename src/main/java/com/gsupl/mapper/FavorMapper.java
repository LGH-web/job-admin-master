package com.gsupl.mapper;

import com.gsupl.entity.Favor;

import java.util.List;

public interface FavorMapper {

	int create(Favor favor);

	int delete(Integer id);

	int update(Favor favor);

	List<Favor> query(Favor favor);

	Favor detail(Integer id);

	int count(Favor favor);
}

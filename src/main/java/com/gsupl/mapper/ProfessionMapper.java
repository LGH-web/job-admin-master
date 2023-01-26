package com.gsupl.mapper;

import com.gsupl.entity.Profession;

import java.util.List;

public interface ProfessionMapper {

	int create(Profession profession);

	int delete(Integer id);

	int update(Profession profession);

	List<Profession> query(Profession profession);

	Profession detail(Integer id);

	int count(Profession profession);
}

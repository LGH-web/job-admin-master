package com.gsupl.mapper;

import com.gsupl.entity.Project;

import java.util.List;

public interface ProjectMapper {

	int create(Project project);

	int delete(Integer id);

	int update(Project project);

	List<Project> query(Project project);

	Project detail(Integer id);

	int count(Project project);
}

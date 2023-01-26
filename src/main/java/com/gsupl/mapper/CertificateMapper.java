package com.gsupl.mapper;

import com.gsupl.entity.Certificate;

import java.util.List;

public interface CertificateMapper {

	int create(Certificate certificate);

	int delete(Integer id);

	int update(Certificate certificate);

	List<Certificate> query(Certificate certificate);

	Certificate detail(Integer id);

	int count(Certificate certificate);
}

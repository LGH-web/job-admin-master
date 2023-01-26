package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Certificate;
import com.gsupl.mapper.CertificateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LGH
 * @Date 2022/11/14 15:08
 * @Version 1.0
 */
@Service
public class CertificateService {
    @Autowired
    private CertificateMapper certificateMapper;

    public int create(Certificate certificate) {
        return certificateMapper.create(certificate);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                certificateMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return certificateMapper.delete(id);
    }

    public int update(Certificate certificate) {
        return certificateMapper.update(certificate);
    }

    public PageInfo<Certificate> query(Certificate certificate) {
        if (certificate != null && certificate.getPage() != null) {
            PageHelper.startPage(certificate.getPage(), certificate.getLimit());
        }
        return new PageInfo<>(certificateMapper.query(certificate));
    }

    public Certificate detail(Integer id) {
        return certificateMapper.detail(id);
    }

    public int count(Certificate certificate) {
        return certificateMapper.count(certificate);
    }
}

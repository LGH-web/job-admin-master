package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Company;
import com.gsupl.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author LGH
 * @Date 2022/11/14 15:27
 * @Version 1.0
 */
@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public int create(Company company) {
        return companyMapper.create(company);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                companyMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return companyMapper.delete(id);
    }

    public int update(Company company) {
        return companyMapper.update(company);
    }

    public int updateSelective(Company company) {
        return companyMapper.updateSelective(company);
    }
    public PageInfo<Company> query(Company company) {
        if (company != null && company.getPage() != null) {
            PageHelper.startPage(company.getPage(), company.getLimit());
        }
        return new PageInfo<>(companyMapper.query(company));
    }

    public Company detail(Integer id) {
        return companyMapper.detail(id);
    }

    public int count(Company company) {
        return companyMapper.count(company);
    }

    public Company login(String account, String password) {
        Company company = new Company();
        company.setAccount(account);
        company.setPassword(password);
        List<Company> list = companyMapper.query(company);
        if(list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}

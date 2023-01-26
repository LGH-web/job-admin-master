package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Student;
import com.gsupl.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author LGH
 * @Date 2022/11/14 15:47
 * @Version 1.0
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int create(Student student) {
        return studentMapper.create(student);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                studentMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return studentMapper.delete(id);
    }

    public int update(Student student) {
        return studentMapper.update(student);
    }

    public int updateSelective(Student student) {
        return studentMapper.updateSelective(student);
    }

    public PageInfo<Student> query(Student student) {
        if (student != null && student.getPage() != null) {
            PageHelper.startPage(student.getPage(), student.getLimit());
        }
        return new PageInfo<>(studentMapper.query(student));
    }

    public Student detail(Integer id) {
        return studentMapper.detail(id);
    }

    public int count(Student student) {
        return studentMapper.count(student);
    }

    public Student login(String account, String password) {
        Student student = new Student();
        student.setAccount(account);
        student.setPassword(password);
        List<Student> list = studentMapper.query(student);
        if(list != null && list.size() >= 1) {
            return list.get(0);
        } else {
            return null;
        }
    }
}

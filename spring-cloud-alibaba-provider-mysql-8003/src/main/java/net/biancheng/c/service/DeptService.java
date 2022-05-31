package net.biancheng.c.service;

import net.biancheng.c.entity.Dept;

import java.util.List;

public interface DeptService {

    Dept get(Integer DeptNo);

    List<Dept> selectAll();
}

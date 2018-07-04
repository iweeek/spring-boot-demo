package com.nijun.demo.repository;

import com.nijun.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/5
 * Time: 12:40 AM
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // 通过年龄来查询
    public List<Girl> findByAge(Integer age);
}

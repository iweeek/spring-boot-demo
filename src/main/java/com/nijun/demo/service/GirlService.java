package com.nijun.demo.service;

import com.nijun.demo.domain.Girl;
import com.nijun.demo.enums.ResultEnum;
import com.nijun.demo.exception.GirlException;
import com.nijun.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/5
 * Time: 1:21 AM
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if (age < 10) {
            // 返回"你还在上小学吧"
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            // 返回"你可能在上初中"
            throw new GirlException(ResultEnum.MIDDLE_ERROR);
        }
    }
}

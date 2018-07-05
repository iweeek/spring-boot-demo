package com.nijun.demo.controller;

import com.nijun.demo.domain.Girl;
import com.nijun.demo.domain.Result;
import com.nijun.demo.repository.GirlRepository;
import com.nijun.demo.service.GirlService;
import com.nijun.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/5
 * Time: 12:39 AM
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * spring初始化的时候就已经实例化所有类
     */
//    public GirlController() {
//    }

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        System.out.println("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生对象
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            return null;
            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        Result success = ResultUtil.success(girl);
        return success;
    }

    /**
     * 查找一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        // getOne得到的是代理对象。
//        Girl one = girlRepository.getOne(id);
        Girl one = girlRepository.findById(id).get();
        return one;
    }

    /**
     * 更新一个女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable Integer id,
                           @RequestParam String cupSize,
                           @RequestParam Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄来查
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 事务
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    /**
     * 获取某女生的年龄并判断
     * 小于10，返回"应该在上小学"
     * 大于10且小于16，返回"可能再上初中"
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}

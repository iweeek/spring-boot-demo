package com.nijun.demo.controller;

import com.nijun.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/4
 * Time: 7:56 PM
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/hello")
public class HelloController {

//    单独配置各个属性
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private int age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
//    @RequestMapping(value = {"/say"}, method = RequestMethod.POST)
//    @RequestMapping(value = "/say") /*POST和GET都可以*/

//    @RequestMapping(value = {"/say/{id}"}, method = RequestMethod.GET) /* /say/23/ */
//    @RequestMapping(value = {"/{id}/say"}, method = RequestMethod.GET) /* /100/say/ */
//    @RequestMapping(value = {"/say"}, method = RequestMethod.GET) /* /say?id=123 */
    @GetMapping(value = "/say")
//    public String say(@RequestParam("id") Integer myId) {
    public String say(@RequestParam(value = "id", required = false, defaultValue = "718") Integer myId) {
//        return girlProperties.getCupSize();
        return "id:" + myId;
    }
}

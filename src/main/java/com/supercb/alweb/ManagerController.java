package com.supercb.alweb;


import com.supercb.alweb.data.*;
import com.supercb.alweb.datamanger.*;
import org.springframework.data.annotation.Transient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    UserRepository userRepository;
    @Resource
    BmanRepository bmanRepository;
    @Resource
    OrderRepository orderRepository;
    @Resource
    MessageRepository messageRepository;

    @Resource
    ArbitrationRepository arbitrationRepository;


    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public void newuser(@RequestBody User user) {
        userRepository.save(user);
    }

    @Transient
    @Transactional
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.POST)
    public void deleteuser(@PathVariable("id") String id) {
        userRepository.deleteUserById(id);
    }

    @RequestMapping(value = "/alluser", method = RequestMethod.POST)
    public ArrayList<User> alluser() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @RequestMapping(value = "/newbman", method = RequestMethod.POST)
    public void newbman(@RequestBody Bman bman) {
        bmanRepository.save(bman);
    }

    @Transactional
    @RequestMapping(value = "/deletebman/{id}", method = RequestMethod.POST)
    public void deletebman(@PathVariable("id") String id) {
        bmanRepository.deleteBmanById(id);
    }

    @RequestMapping(value = "/allbman", method = RequestMethod.POST)
    public ArrayList<Bman> allbman() {
        return (ArrayList<Bman>) bmanRepository.findAll();
    }


    @RequestMapping(value = "/allorder", method = RequestMethod.POST)
    public ArrayList<TheOrder> allorders() {

        System.out.println("fuck");
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(0);
        integerTreeSet.add(1);
        integerTreeSet.add(2);
        integerTreeSet.add(3);
        return orderRepository.findTheOrdersBySituationIn(integerTreeSet);
    }

    @RequestMapping(value = "/allsuccess", method = RequestMethod.POST)
    public ArrayList<TheOrder> allsuccessorders() {
        return orderRepository.findTheOrdersBySituation(3);
    }


    @RequestMapping(value = "/message/{itemid}", method = RequestMethod.POST)
    public ArrayList<Message> allmessage(@PathVariable("itemid") Integer itemid) {
        return messageRepository.findMessagesByItemid(itemid);
    }

    @RequestMapping(value = "/judge", method = RequestMethod.POST)
    public ArrayList<Arbitration> allarbitraion() {


        return arbitrationRepository.findAll();
    }

    @RequestMapping(value = "/cjudge", method = RequestMethod.POST)
    public void confirmjudge(@RequestBody Arbitration arbitration) {
        Arbitration arbitration1 = arbitrationRepository.findArbitrationById(arbitration.getId());
        arbitration1.setResult(arbitration.getResult());
        arbitrationRepository.save(arbitration1);
        TheOrder theOrder = orderRepository.findTheOrderById(arbitration.getOrderid());
//        System.out.println(arbitration.getOrderid());
        theOrder.setSituation(5);
        orderRepository.save(theOrder);
    }
}

package com.supercb.alweb;

import com.supercb.alweb.data.ItemInfor;
import com.supercb.alweb.data.TheOrder;
import com.supercb.alweb.datamanger.ItemInforRepository;
import com.supercb.alweb.datamanger.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.TreeSet;

@RestController
@RequestMapping("/bman")
public class BmanController {


    @Resource
    ItemInforRepository itemInforRepository;

    @Resource
    OrderRepository orderRepository;

    @RequestMapping(value = "/newitem", method = RequestMethod.POST)
    public void addnewitem(@RequestBody ItemInfor itemInfor) {
        itemInforRepository.save(itemInfor);
    }

    @RequestMapping(value = "/allorders/{id}", method = RequestMethod.POST)
    public ArrayList<TheOrder> getallorders(@PathVariable("id") String str) {
        return orderRepository.findTheOrdersByBmid(str);
    }

    @RequestMapping(value = "/accept/{id}", method = RequestMethod.POST)
    public void acceptorder(@PathVariable("id") Integer id) {
        TheOrder theOrder = orderRepository.findTheOrderById(id);
        theOrder.setSituation(1);
        orderRepository.save(theOrder);
    }

    @RequestMapping(value = "/delivery/{id}", method = RequestMethod.POST)
    public void  getallorders(@PathVariable("id") Integer id) {
        TheOrder theOrder = orderRepository.findTheOrderById(id);
        theOrder.setSituation(2);
        orderRepository.save(theOrder);
    }

    @RequestMapping(value = "/replymessage/{id}", method = RequestMethod.POST)
    public ArrayList<ItemInfor> replymessage(@PathVariable("id")String id) {
        return itemInforRepository.findItemInforsByBmid(id);
    }
}

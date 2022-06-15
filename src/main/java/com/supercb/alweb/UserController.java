package com.supercb.alweb;

import com.supercb.alweb.data.ItemInfor;
import com.supercb.alweb.data.Message;
import com.supercb.alweb.data.TheOrder;
import com.supercb.alweb.datamanger.ItemInforRepository;
import com.supercb.alweb.datamanger.MessageRepository;
import com.supercb.alweb.datamanger.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    ItemInforRepository itemInforRepository;

    @Resource
    MessageRepository messageRepository;

    @Resource
    OrderRepository orderRepository;

    @RequestMapping(value = "/alliteminfor", method = RequestMethod.POST)
    public ArrayList<ItemInfor> getallIteminfor() {
        return (ArrayList<ItemInfor>) itemInforRepository.findAll();
    }

    @RequestMapping(value = "/newmessage", method = RequestMethod.POST)
    public void addnewmessage(@RequestBody Message message) {
        messageRepository.save(message);
        ItemInfor itemInfor = itemInforRepository.findItemInforById(message.getItemid());
        itemInfor.setMessagecount(itemInfor.getMessagecount() + 1);
        itemInforRepository.save(itemInfor);
    }

    @RequestMapping(value = "/neworder", method = RequestMethod.POST)
    public void addneworder(@RequestBody TheOrder theOrder) {
        orderRepository.save(theOrder);
    }

    @RequestMapping(value = "/allorder/{userid}", method = RequestMethod.POST)
    public ArrayList<TheOrder> allorder(@PathVariable("userid") String id) {
        return orderRepository.findTheOrdersByUserid(id);
    }

    @RequestMapping(value = "/orderover/{itemid}", method = RequestMethod.POST)
    public void orderover(@PathVariable("itemid") Integer itemid) {
        TheOrder theOrder = orderRepository.findTheOrderById(itemid);
        theOrder.setSituation(3);
        orderRepository.save(theOrder);
    }

    /**
     * 申请调解时调用的函数
     *
     * @param itemid
     * @param reason
     */
    @RequestMapping(value = "/orderover/{itemid}/{reason}", method = RequestMethod.POST)
    public void question(@PathVariable("itemid") Integer itemid, @PathVariable("reason") String reason) {
        System.out.println("dsaf ");
        TheOrder theOrder = orderRepository.findTheOrderById(itemid);
        theOrder.setSituation(4);
        theOrder.setQuestion(reason);
        orderRepository.save(theOrder);
    }
}

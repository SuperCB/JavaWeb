package com.supercb.alweb.datamanger;

import com.supercb.alweb.data.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MessageRepository extends JpaRepository<Message,Integer> {


    ArrayList<Message> findMessagesByItemid(Integer id);
}

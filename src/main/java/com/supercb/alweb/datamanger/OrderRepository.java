package com.supercb.alweb.datamanger;

import com.supercb.alweb.data.TheOrder;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Set;

public interface OrderRepository extends JpaRepository<TheOrder, Integer> {

   ArrayList<TheOrder> findTheOrdersBySituationIn(Set<Integer>integerSet);

   ArrayList<TheOrder> findTheOrdersBySituation(Integer integer);

   ArrayList<TheOrder> findTheOrdersByUserid(String str);

   ArrayList<TheOrder> findTheOrdersByBmid(String id);

   TheOrder findTheOrderById(Integer integer);
}

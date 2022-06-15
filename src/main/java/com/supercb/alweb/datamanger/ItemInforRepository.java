package com.supercb.alweb.datamanger;

import com.supercb.alweb.data.ItemInfor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

public interface ItemInforRepository extends JpaRepository<ItemInfor, Integer> {
    ItemInfor findItemInforById(Integer id);

    ArrayList<ItemInfor> findItemInforsByBmid(String id);
}

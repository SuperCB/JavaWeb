package com.supercb.alweb.datamanger;

import com.supercb.alweb.data.Arbitration;
import com.supercb.alweb.data.Bman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ArbitrationRepository extends JpaRepository<Arbitration, Integer> {
    ArrayList<Arbitration> findAll();

    Arbitration findArbitrationById(Integer id);
}

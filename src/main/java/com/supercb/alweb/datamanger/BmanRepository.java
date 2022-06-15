package com.supercb.alweb.datamanger;

import com.supercb.alweb.data.Bman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BmanRepository extends JpaRepository<Bman, Integer> {
    Bman findBmanByIdAndPasswd(String id,String pass);

    void deleteBmanById(String id);
}

package com.supercb.alweb;

import com.supercb.alweb.data.Bman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BMRepository extends JpaRepository<Bman,Integer> {

}

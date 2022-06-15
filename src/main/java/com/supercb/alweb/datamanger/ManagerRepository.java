package com.supercb.alweb.datamanger;

import com.supercb.alweb.data.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findManagerByIdAndPasswd(String id, String pass);
}

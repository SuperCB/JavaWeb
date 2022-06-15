package com.supercb.alweb.datamanger;

import com.supercb.alweb.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByIdAndPasswd(String id, String pass);

    void deleteUserById(String id);
}

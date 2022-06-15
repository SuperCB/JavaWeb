package com.supercb.alweb;


import com.supercb.alweb.data.FrontData;
import com.supercb.alweb.data.User;
import com.supercb.alweb.datamanger.BmanRepository;
import com.supercb.alweb.datamanger.ManagerRepository;
import com.supercb.alweb.datamanger.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class LoginController {


    @Resource
    BmanRepository bmanRepository;
    @Resource
    UserRepository userRepository;
    @Resource
    ManagerRepository managerRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String newuser(@RequestBody FrontData frontData) {

        if (Objects.equals(frontData.getIdentity(), "用户")) {

            if (userRepository.findUserByIdAndPasswd(frontData.getId(), frontData.getPassword()) == null) {
                return "false";
            }
        } else if (Objects.equals(frontData.getIdentity(), "商家")) {
            if (bmanRepository.findBmanByIdAndPasswd(frontData.getId(), frontData.getPassword()) == null) {
                return "false";
            }
        } else if (Objects.equals(frontData.getIdentity(), "管理员")) {
            if (managerRepository.findManagerByIdAndPasswd(frontData.getId(), frontData.getPassword()) == null) {
                return "false";
            }
        }
        return "yes";
    }


}

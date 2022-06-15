package com.supercb.alweb;

import com.supercb.alweb.data.*;
import com.supercb.alweb.datamanger.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class AlWebApplicationTests {

    @Resource
    UserRepository userRepository;


    @Resource
    ItemInforRepository itemInforRepository;

    @Resource
    BMRepository bmRepository;
    @Resource
    OrderRepository orderRepository;
    @Resource
    MessageRepository messageRepository;

    @Test
    void newmessage() {
        String[] str = {
                "质量上乘，值得信赖",
                "品质保证，值得信赖",
                "可以详细讨论铝材的价格吗?",
                "最快多久能发货?"
        };
        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setContent(str[i % 4]);
            message.setSpeakerId(String.format("张辉%d", i));
            message.setIdentity(i % 2);
            message.setItemid(1);
            message.setDate(new Date().toString());
            messageRepository.save(message);
        }
    }

    @Test
    void neworders() {
        for (int i = 0; i < 10; i++) {
            TheOrder theOrder = new TheOrder();
            theOrder.setUserid(String.format("1000%d", i));
            theOrder.setBmid(String.format("1234%d", i));
            theOrder.setDate(new Date().toString());
            theOrder.setPrice(1234.0);
            theOrder.setEnsureprice(21.0);
            theOrder.setItemid(2);
            theOrder.setCompanyname(String.format("蓝鲸%d公司", i));
            theOrder.setItemname("上好的铝材");
            theOrder.setSituation(i % 5);
            orderRepository.save(theOrder);
        }
    }

    @Test
    void contextLoads() {

        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setId(String.format("1000%d", i));
            user.setPasswd("123456");
            userRepository.save(user);

            Bman bman = new Bman();

            bman.setId(String.format("1234%d", i));
            bman.setName("飞龙公司");
            bman.setPasswd("123456");
            bmRepository.save(bman);
        }

        String[] names = {
                "辽宁忠旺集团有限公司 ",
                "肇庆亚洲铝厂有限公司",
                "广东兴发铝业有限公司",
                "广东凤铝铝业有限公司",
                "广东伟业铝厂集团有限公司",
                "广东坚美铝型材厂(集团)有限公司"
        };
        String[] descis = {
                "中国忠旺控股有限公司是全球领先的工业铝型材研发制造商，公司致力于交通运输、机械设备及电力工程等领域的轻量化发展。根据波士顿咨询公司之相关统计，公司是目前全球第二大、亚洲及中国最大的工业铝型材研发制造商。",
                "肇庆亚洲铝厂有限公司是亚洲地区较大的铝型材制造商。自1991年成立以来，公司一直致力于高、精、尖铝挤压型材的设计与制造，通过多年以来的不懈努力和坚持，亚铝产品由单一的建筑门窗、幕墙类铝型材拓展到包括各类工业型材、航天航空、轨道交通、汽车制造、电子电器、通讯科技、IT等多种领域，产品遍布世界各地。",
                "兴发铝业是中国大陆最早生产铝型材的企业之一，现已成为中国著名的专业生产建筑铝型材、工业铝型材的大型企业，是中国建设部铝合金型材定点生产基地。",
                "广东凤铝铝业有限公司成立于1990年，是集铝合金研发、生产与销售等为一体的综合性大型民营铝型材企业。拥有南海和三水两个大型生产基地，占地总面积80万平方米，建筑面积近70万平方米。",
                "一九九二年广东伟业铝厂有限公司，在中国铝材第一镇南海大沥成立，公司自成立始终坚持“科技兴伟业，质量创名牌”质量方针，严格按照ISO9001，ISO14000、OHSAS18001等国际标准体系进行生产控制。",
                "广东坚美铝型材厂（集团）有限公司是一家集铝合金建筑型材、工业铝型材和铝合金门窗幕墙研究、设计、生产及销售于一体的综合性大型企业，是中国铝型材行业排头兵企业、国家建设部建筑金属材料和铝门窗幕墙定点生产企业，国家铝型材行业标准重要修订单位之一，国家发展改革委、商务部鼓励投资的特种大型铝合金型材产品研发企业。"
        };
        for (int i = 0; i < 6; i++) {
            ItemInfor itemInfor = new ItemInfor();
            itemInfor.setBmid("12340");
            itemInfor.setName(names[i]);
            itemInfor.setCompanyname(names[i]);
            itemInfor.setLocation("广东");
            itemInfor.setDescription(descis[i]);
            itemInfor.setPrice((double) new Random().nextInt(100));
            itemInfor.setMessagecount(new Random().nextInt(10));
            itemInforRepository.save(itemInfor);
        }
    }

    @Resource
    ManagerRepository managerRepository;

    @Test
    void test1() {

        Manager manager = new Manager();
        manager.setId("m123");
        manager.setPasswd("123456");
        managerRepository.save(manager);

    }

    @Autowired
    ArbitrationRepository arbitrationRepository;

    @Test
    void arbitration() {
        String[] names = {
                "特种铝材",
                "耐磨铝材",
                "抗高压高温铝材"
        };
        for (int i = 0; i < 5; i++) {
            Arbitration arbitration = new Arbitration();
            arbitration.setItemname(names[i % 3]);
            arbitration.setBmid("12340");
            arbitration.setItemid(1);
            arbitration.setOrderid(i + 11);
            arbitration.setUserid("10000");
            arbitration.setQuestion("产品质量有严重问题");
            arbitrationRepository.save(arbitration);
        }

    }


}

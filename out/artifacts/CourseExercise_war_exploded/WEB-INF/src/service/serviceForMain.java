package service;

import bean.main.A10;

public interface serviceForMain {
    /**
    * @Description: 取出登录得到的用户bean
    **/
    A10 SignIn(String name, String pass);

    /**
    * @Description: 预约
    **/
    void addBookingPatientBasicInformation(String name, String identityCard,String phoneNumber);


}

package service;

import bean.main.A10;

public interface serviceForMain {
    /**
    * @Description: ȡ����¼�õ����û�bean
    **/
    A10 SignIn(String name, String pass);

    /**
    * @Description: ԤԼ
    **/
    void addBookingPatientBasicInformation(String name, String identityCard,String phoneNumber);


}

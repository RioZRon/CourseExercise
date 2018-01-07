package service;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;

import java.util.ArrayList;

public interface serviceForMedicine {
    /**
    * @Description: 更新输出A60表
    **/
    ArrayList<A60> UpdateAndSelectAlertA60();

    /**
    * @Description: 显示药品详情
    **/
    A60 SelectMedicinDetail(int a601);

    /**
    * @Description: 添加入库流水
    **/
    void AddFlowIn(A62 a62);

    /**
    * @Description: 入库提交后修改对应的RemainNum
    **/
    void UpdateRemainNumByA62(A62 a62);
}

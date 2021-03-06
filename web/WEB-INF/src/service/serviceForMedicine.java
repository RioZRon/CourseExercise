package service;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;
import bean.medicine.A63;

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
    * @Description:添加出库流水
    **/
    void AddFlowOut(A63 a63);


    /**
    * @Description: 入库提交后修改对应的RemainNum
    **/
    void UpdateRemainNumByA62(A62 a62);
    /**
     * @Description: 出库提交后修改对应的RemainNum
     **/
    void UpdateRemainNumByA63(A63 a63);
    /**
     * @Description: 根据药品名和id模糊查询
     **/
    ArrayList<A60> FindMedicines(String name, String id);

   /**
   * @Description: 更新药品基本信息
   **/
    void UpdateMedicine(A60 a60);

    /**
    * @Description: 添加药品基本信息
    **/
    int AddMedicineAndReturna601(A60 a60);

    /**
    * @Description: 根据id搜索A21表的A214
    **/
    String SelectMedicineNeeded(int a201);

    /**
    * @Description: 显示所有的对应药物
    **/
    ArrayList<A60> ShowAllNeededMedicine(String a217);

    /**
    * @Description: 搜索进价
    **/
    int SelectInprice(int a601);

    /**
    * @Description: 更新217处方
    **/
    void UpdatePrescrpe(int a201,String new217);

    /**
    * @Description: 根据a602搜索a601
    **/
    int SelectMedicinId(String a602);

}

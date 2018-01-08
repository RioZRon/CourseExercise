package service;

import bean.main.A10;
import bean.medicine.A60;
import bean.medicine.A62;
import bean.medicine.RemainNum;
import bean.outpatientdocter.A21;
import bean.register.A20;
import dao.daoIMP;
import servlet.medicine.SelectAllAlertMedicine;
import tools.JDBCPool;
import tools.JDBCPoolTools;
import tools.OtherTools;
import tools.StringTools;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class serviceIMP implements serviceForMain, serviceForHr, serviceForRegistration, serviceForOutPatientDocter, serviceForMedicine{
    /**
     * @param name
     * @param pass
     * @Description: ȡ����¼�õ����û�bean
     */
    @Override
    public A10 SignIn(String name, String pass) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoImp = new daoIMP();
//        System.out.println(name + pass);
        A10 a10= daoImp.SelectA10ByA103A104(connection, name, pass);
//        System.out.println(a10.toString());
        return a10;
    }

    /**
     * @param a10
     * @Description: ����û���Ϣ
     */
    @Override
    public void AddStaff(A10 a10) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A10insert(connection, a10);
    }

    /**
     * @param name  û��Ϊnull
     * @param username  û�о�Ϊnull
     * @Description: �����û���Ϣ
     */
    @Override
    public ArrayList<A10> FindStaffs(String name, String username) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        ArrayList<A10> a10ArrayList = daoIMP.SelectA10Bya102a103inDark(connection,name,username);
        return  a10ArrayList;
    }

    /**
     * @param id
     * @Description: ɾ���û�
     */
    @Override
    public void DeleteStaff(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.DeleteA10Bya101(connection, id);
    }

    /**
     * @param username
     * @Description: �����û���Ϣ username
     */
    @Override
    public A10 FindStaff(String username) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        A10 a10= daoIMP.SelectA10Bya103(connection,username);
        return  a10;
    }

    /**
     * @param a10
     * @Description: �޸��û�
     */
    @Override
    public void UpdateStaff(A10 a10) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA10(connection, a10);
    }

    /**
     * @param a20
     * @Description: ��Ӳ���A20
     */
    @Override
    public void addPatientBasicInformation(A20 a20) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A20insert(connection, a20);
    }

    /**
     * @param name
     * @param id
     * @Description: ��������
     */
    @Override
    public ArrayList<A20> FindPatients(String name, String id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        a20ArrayList = daoIMP.SelectA20Bya201a202inDark(connection,name,id);
        return a20ArrayList;
    }

    /**
     * @param id
     * @Description: ��������(��׼)
     */
    @Override
    public A20 FindPatient(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        return daoIMP.SelectA20Bya201(connection, id);
    }

    /**
     * @param a20
     * @Description: �޸Ĳ���(��׼)
     */
    @Override
    public void UpdatePatient(A20 a20) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA20(connection, a20);
    }

    /**
     * @param id
     * @Description: �õ�ҽ����Ӧ�Ŀ���
     */
    @Override
    public int FindDoctorRoom(int id) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        int roomid = daoIMP.Selecta133Bya131(connection, id);
        return roomid;
    }

    /**
     * @param a2010
     * @Description: �������з��䵽������ҵĲ���
     */
    @Override
    public ArrayList<A20> FindPatientsBya2010(int a2010) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        a20ArrayList = daoIMP.SelectA20Bya2010(connection,a2010);
        return a20ArrayList;
    }

    /**
     * @param a211
     * @Description: ���ݹҺŲ�ѯ����
     */
    @Override
    public A21 FindMedicalrecord(int a211) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        return daoIMP.SelectA21Bya211(connection, a211);
    }

    /**
     * @param a21
     * @Description: ��Ӳ���(Ŀǰ��ӵĶ��ǿյ� ֻ�б�� ��Ϣȫ��update)
     */
    @Override
    public void addEmptyFindMedicalrecord(A21 a21) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A21insertBya211(connection, a21.getA211());
    }

    /**
     * @param a21
     * @Description: �޸�A21
     */
    @Override
    public void UpdateMedicalrecord(A21 a21) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA21(connection, a21);

    }

    /**
     * @Description: ����A60��
     **/
    @Override
    public ArrayList<A60> UpdateAndSelectAlertA60() {
        Connection connection = JDBCPoolTools.getConnection();
//        ���������� �õ����е�id,name, ������, ����, ��������
        ArrayList<A60> a60s = new ArrayList<>();
        ArrayList<A60> result = new ArrayList<>();
        daoIMP daoIMP = new daoIMP();
        a60s = daoIMP.SelectAllA60(connection);
        //������ҳ�Ŀ������ дһ�����·���
        for(A60 a60each : a60s){
            OtherTools.RemainNumUpdate(a60each);
            //���¶�Ӧ�Ŀ��
            daoIMP.UpdateA60Bya607(connection, a60each.getA601(),a60each.getA607());
            //��ȡ����
            RemainNum remainNum = StringTools.StringToRemainNum(a60each.getA607());
            int sum = 0;
            for (Map.Entry<Integer,Integer> entry: remainNum.getTreeMap().entrySet()){
                sum+= entry.getValue();
            }
            if (sum  < a60each.getA608()){
                result.add(a60each);
            }
        }
        if(result.isEmpty())
            return null;
        return result;
    }

    /**
     * @param a601
     * @Description: ��ʾҩƷ����
     */
    @Override
    public A60 SelectMedicinDetail(int a601) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        A60 a60 = daoIMP.SelectA60ByA601(connection, a601);
        return a60;
    }

    /**
     * @param a62
     * @Description: ��������ˮ
     */
    @Override
    public void AddFlowIn(A62 a62) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A62insert(connection, a62);
    }

    /**
     * @param a62
     * @Description: ����ύ���޸Ķ�Ӧ��RemainNum
     */
    @Override
    public void UpdateRemainNumByA62(A62 a62) {
        Connection coonnection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        int id = a62.getA622();
        int num  = a62.getA625();
        Date date = a62.getA628();
        A60 a60 = daoIMP.SelectA60ByA601(coonnection,id);
        RemainNum remainNum = StringTools.StringToRemainNum(a60.getA607());
        int minu = OtherTools.DifferentDaysByMillisecond(date,  remainNum.getDate());
        //�ж������ǲ��Ǳ�������̵�
        //����������, ��������ʱ��
        int keynew = 0;
        int valuenew = 0;
        if(date.compareTo(remainNum.getDate()) >= 0){
            keynew = OtherTools.GetMinKey(remainNum.getTreeMap()) + minu;
        }else {
            keynew  = OtherTools.GetMinKey(remainNum.getTreeMap()) - minu;
            remainNum.setDate(date);
        }
        TreeMap<Integer,Integer> treeMapnew = remainNum.getTreeMap();
        valuenew = num;
        if (treeMapnew.containsKey(keynew)) {
            int valueold = treeMapnew.get(keynew);
            valuenew += valueold;
            treeMapnew.put(keynew, valuenew);
        }else {
            treeMapnew.put(keynew, valuenew);
        }
        remainNum.setTreeMap(treeMapnew);
        String a607 = StringTools.RemainNumToString(remainNum);
        daoIMP.Updatea607Bya601(coonnection, id, a607);
    }

    /**
     * @param name
     * @param id
     * @Description: ����ҩƷ����idģ����ѯ
     */
    @Override
    public ArrayList<A60> FindMedicines(String name, String id) {
            Connection connection = JDBCPoolTools.getConnection();
            daoIMP daoIMP = new daoIMP();
            ArrayList<A60> a60ArrayList = new ArrayList<>();
            a60ArrayList = daoIMP.SelectA60Bya601a602inDark(connection,name,id);
            return a60ArrayList;
        }

    /**
     * @param a60
     * @Description: ����ҩƷ������Ϣ
     */
    @Override
    public void UpdateMedicine(A60 a60) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.UpdateA60(connection, a60);
    }

    /**
     * @param a60
     * @Description: ���ҩƷ������Ϣ
     */
    @Override
    public int AddMedicineAndReturna601(A60 a60) {
        Connection connection = JDBCPoolTools.getConnection();
        daoIMP daoIMP = new daoIMP();
        daoIMP.A60insert(connection, a60);
        int id = daoIMP.Selecta601Bya602(connection, a60.getA602());
        return id;
    }
}

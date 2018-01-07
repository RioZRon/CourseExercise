package bean.medicine;

import java.util.Date;
import java.util.TreeMap;

public class RemainNum {
//    String Remain = "2018-11-1 | 10:6, 15:50, 50:10"
    //离现在最远时间
    private Date date;
    private TreeMap<Integer, Integer> treeMap = new TreeMap<>();

//    @Override
//    public String toString() {
//        return "RemainNum{" +
//                "date=" + date.toString() +
//                ", treeMap=" + treeMap.toString() +
//                '}';
//    }


    public RemainNum(Date date, TreeMap<Integer, Integer> treeMap) {
        this.date = date;
        this.treeMap = treeMap;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TreeMap<Integer, Integer> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(TreeMap<Integer, Integer> treeMap) {
        this.treeMap = treeMap;
    }
}

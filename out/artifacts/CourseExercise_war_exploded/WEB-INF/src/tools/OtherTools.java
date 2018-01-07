package tools;

import bean.medicine.A60;
import bean.medicine.RemainNum;
import tools.StringTools;

import java.util.*;

public class OtherTools {

    public static int DifferentDaysByMillisecond(Date date1, Date date2) {
        int days = Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
        return days;
    }


    /**
     * @Description: 获取key最大的
     * @param:
     * @return:
     * @Date:
     **/
    public static int GetMinKey(Map<Integer, Integer> map) {
        boolean flag = false;
        int min = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!flag) {
                min = entry.getKey();
                flag = true;
            }
            if (entry.getKey() < min) {
                min = entry.getKey();
            }
        }
        return min;
    }


    /**
     * @param: a60
     * @Description: 显示实际数量
     **/
    public static A60 RemainNumUpdate(A60 a60) {
        if (a60.getA607() == null) {
            return a60;
        } else {
            RemainNum remainNum = StringTools.StringToRemainNum(a60.getA607());
            TreeMap<Integer, Integer> treeMap = remainNum.getTreeMap();
            TreeMap<Integer, Integer> treeMapNew = new TreeMap<>();
            int remainO = GetMinKey(treeMap);
            int timeR = a60.getA606();
            int nowToFlag = DifferentDaysByMillisecond(new Date(), remainNum.getDate());
            int menu = timeR - nowToFlag;
            Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int key = entry.getKey() - menu;
                if (key > 0) {
                    treeMapNew.put(key, entry.getValue());
                }
            }
            if (treeMapNew.isEmpty()) {
                String newA607 = null;
                a60.setA607(newA607);
                return a60;
            }
            remainNum.setTreeMap(treeMapNew);
            //更换标志时间  先获取现在最小时间 减去之前最小时间现在应该剩下(如果为负数得到正数的天数)
            int gap = GetMinKey(treeMapNew) - remainO + menu;
            Date dateO = remainNum.getDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(dateO);
            calendar.add(Calendar.DATE, gap);
            Date dateN = calendar.getTime();
            remainNum.setDate(dateN);
            String newA607 = StringTools.RemainNumToString(remainNum);
            a60.setA607(newA607);
            return a60;
        }
    }


    public static int RemainNumToNumber(A60 a60) {
        RemainNum remainNum = StringTools.StringToRemainNum(a60.getA607());
        int sum = 0;
        for (
                Map.Entry<Integer, Integer> entry : remainNum.getTreeMap().entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }
}

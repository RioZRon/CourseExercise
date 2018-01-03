package tools;

public class programTools {
    static String RoleTurn(String str){
        if (str.equals("1"))
            return "挂号";
        else if(str.equals("2"))
            return "门诊";
        else if(str.equals("3"))
            return "病房";
        else if (str.equals("4"))
            return "手术";
        else if(str.equals("5"))
            return "管理员";
        else
            return null;
    }
}

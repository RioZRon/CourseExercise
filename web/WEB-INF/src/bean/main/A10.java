package bean.main;

public class A10 {
    private int A101, A105;
    private String A102, A103, A104;
//    ¹¹ÔìÆ÷

    public A10() {
    }

    public A10(String a102, String a103, String a104, int a105) {
        A102 = a102;
        A103 = a103;
        A104 = a104;
        A105 = a105;
    }

    public A10(int a101, String a102, String a103, String a104, int a105) {
        A101 = a101;
        A102 = a102;
        A103 = a103;
        A104 = a104;
        A105 = a105;
    }


    @Override
    public String toString() {
        return "A10{" +
                "A101=" + A101 +
                ", A102='" + A102 + '\'' +
                ", A103='" + A103 + '\'' +
                ", A104='" + A104 + '\'' +
                ", A105='" + A105 +
                '}';
    }

    //    SetGet
    public int getA101() {
        return A101;
    }

    public void setA101(int a101) {
        A101 = a101;
    }

    public String getA102() {
        return A102;
    }

    public void setA102(String a102) {
        A102 = a102;
    }

    public String getA103() {
        return A103;
    }

    public void setA103(String a103) {
        A103 = a103;
    }

    public String getA104() {
        return A104;
    }

    public void setA104(String a104) {
        A104 = a104;
    }

    public int getA105() {
        return A105;
    }

    public void setA105(int a105) {
        A105 = a105;
    }
}
package bean.medicine;

import java.sql.Date;

public class A62 {
    private int a621, a622, a625, a627;
    private String a623, a626;
    private Date a624, a628;

    public A62() {
    }

    public A62(int a622, int a625, int a627, String a623, String a626, Date a624, Date a628) {
        this.a622 = a622;
        this.a625 = a625;
        this.a627 = a627;
        this.a623 = a623;
        this.a626 = a626;
        this.a624 = a624;
        this.a628 = a628;
    }

    public A62(int a621, int a622, int a625, int a627, String a623, String a626, Date a624, Date a628) {
        this.a621 = a621;
        this.a622 = a622;
        this.a625 = a625;
        this.a627 = a627;
        this.a623 = a623;
        this.a626 = a626;
        this.a624 = a624;
        this.a628 = a628;
    }

    @Override
    public String toString() {
        return "A62{" +
                "a621=" + a621 +
                ", a622=" + a622 +
                ", a625=" + a625 +
                ", a627=" + a627 +
                ", a623='" + a623 + '\'' +
                ", a626='" + a626 + '\'' +
                ", a624=" + a624 +
                ", a628=" + a628 +
                '}';
    }

    public int getA621() {
        return a621;
    }

    public void setA621(int a621) {
        this.a621 = a621;
    }

    public int getA622() {
        return a622;
    }

    public void setA622(int a622) {
        this.a622 = a622;
    }

    public int getA625() {
        return a625;
    }

    public void setA625(int a625) {
        this.a625 = a625;
    }

    public int getA627() {
        return a627;
    }

    public void setA627(int a627) {
        this.a627 = a627;
    }

    public String getA623() {
        return a623;
    }

    public void setA623(String a623) {
        this.a623 = a623;
    }

    public String getA626() {
        return a626;
    }

    public void setA626(String a626) {
        this.a626 = a626;
    }

    public Date getA624() {
        return a624;
    }

    public void setA624(Date a624) {
        this.a624 = a624;
    }

    public Date getA628() {
        return a628;
    }

    public void setA628(Date a628) {
        this.a628 = a628;
    }
}

package bean.medicine;

import java.sql.Date;

public class A63 {
    private int a631, a632, a635, a636;
    private String a633;
    private Date a634;

    public A63() {
    }

    public A63(int a632, int a635, int a636, String a633, Date a634) {
        this.a632 = a632;
        this.a635 = a635;
        this.a636 = a636;
        this.a633 = a633;
        this.a634 = a634;
    }

    public A63(int a631, int a632, int a635, int a636, String a633, Date a634) {

        this.a631 = a631;
        this.a632 = a632;
        this.a635 = a635;
        this.a636 = a636;
        this.a633 = a633;
        this.a634 = a634;
    }

    @Override
    public String toString() {
        return "A63{" +
                "a631=" + a631 +
                ", a632=" + a632 +
                ", a635=" + a635 +
                ", a636=" + a636 +
                ", a633='" + a633 + '\'' +
                ", a634=" + a634 +
                '}';
    }

    public int getA631() {
        return a631;
    }

    public void setA631(int a631) {
        this.a631 = a631;
    }

    public int getA632() {
        return a632;
    }

    public void setA632(int a632) {
        this.a632 = a632;
    }

    public int getA635() {
        return a635;
    }

    public void setA635(int a635) {
        this.a635 = a635;
    }

    public int getA636() {
        return a636;
    }

    public void setA636(int a636) {
        this.a636 = a636;
    }

    public String getA633() {
        return a633;
    }

    public void setA633(String a633) {
        this.a633 = a633;
    }

    public Date getA634() {
        return a634;
    }

    public void setA634(Date a634) {
        this.a634 = a634;
    }
}

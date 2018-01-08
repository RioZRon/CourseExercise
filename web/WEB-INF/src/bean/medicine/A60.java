package bean.medicine;

public class A60 {
    private int a601, a605, a606, a608, a603;
    private String a602, a604, a607, a609, a6010;

    public A60(int a605, int a606, int a608, int a603, String a602, String a604, String a607, String a609, String a6010) {
        this.a605 = a605;
        this.a606 = a606;
        this.a608 = a608;
        this.a603 = a603;
        this.a602 = a602;
        this.a604 = a604;
        this.a607 = a607;
        this.a609 = a609;
        this.a6010 = a6010;
    }

    public A60(int a601, String a602, int a606, String a607, int a608) {
        this.a601 = a601;
        this.a602 = a602;
        this.a606 = a606;
        this.a607 = a607;
        this.a608 = a608;
    }

    public A60(int a601, int a605, int a606, int a608, String a602, int a603, String a604, String a607, String a609, String a6010) {
        this.a601 = a601;
        this.a605 = a605;
        this.a606 = a606;
        this.a608 = a608;
        this.a602 = a602;
        this.a603 = a603;
        this.a604 = a604;
        this.a607 = a607;
        this.a609 = a609;
        this.a6010 = a6010;
    }

    public int getA601() {
        return a601;
    }

    public void setA601(int a601) {
        this.a601 = a601;
    }

    public int getA605() {
        return a605;
    }

    public void setA605(int a605) {
        this.a605 = a605;
    }

    public int getA606() {
        return a606;
    }

    public void setA606(int a606) {
        this.a606 = a606;
    }

    public int getA608() {
        return a608;
    }

    public void setA608(int a608) {
        this.a608 = a608;
    }

    public String getA602() {
        return a602;
    }

    public void setA602(String a602) {
        this.a602 = a602;
    }

    public int getA603() {
        return a603;
    }

    public void setA603(int a603) {
        this.a603 = a603;
    }

    public String getA604() {
        return a604;
    }

    public void setA604(String a604) {
        this.a604 = a604;
    }

    public String getA607() {
        return a607;
    }

    public void setA607(String a607) {
        this.a607 = a607;
    }

    public String getA609() {
        return a609;
    }

    public void setA609(String a609) {
        this.a609 = a609;
    }

    public String getA6010() {
        return a6010;
    }

    public void setA6010(String a6010) {
        this.a6010 = a6010;
    }

    @Override
    public String toString() {
        return "A60{" +
                "a601=" + a601 +
                ", a605=" + a605 +
                ", a606=" + a606 +
                ", a608=" + a608 +
                ", a602='" + a602 + '\'' +
                ", a603='" + a603 + '\'' +
                ", a604='" + a604 + '\'' +
                ", a607='" + a607 + '\'' +
                ", a609='" + a609 + '\'' +
                ", a6010='" + a6010 + '\'' +
                '}';
    }
}

package utildemo;

import java.util.Date;

public final class FinalClassDemo {

    private final int sal;
    private final String name;
    private final Date doj;

    public FinalClassDemo(int sal, String name, Date doj) {
        this.sal = sal;
        this.name = name;
        this.doj = doj;
    }

    public int getSal() {
        return this.sal;
    }

    public String getName() {
        return this.name;
    }

    public Date getDoj() {
        return (Date) this.doj.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || this.getClass() != obj.getClass()) {
            return false;
        }
        FinalClassDemo object = (FinalClassDemo) obj;
        return this.getSal() == object.getSal() && this.getName().equals(object.getName()) && this.doj.compareTo(object.doj) == 0;
    }

    public int hashCode() {
        final int prime = 11;
        int hashCode = 1;
        hashCode = prime * hashCode + sal;
        hashCode = prime * hashCode + (null == name ? 0 : name.hashCode());
        hashCode = prime * hashCode + (null == doj ? 0 : doj.hashCode());
        return hashCode;
    }
}

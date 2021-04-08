package access;

import java.util.Date;

final class FinalClass {

    private final String key;
    private final int value;
    private final Date date;

    public FinalClass(String key, int value, Date date) {
        this.key = key;
        this.value = value;
        this.date = date;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public Date getDate() {
        return (Date) this.date.clone();
    }

    public String toString() {
        return key + "\t" + value + "\t" + date;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || this.getClass() != obj.getClass()) {
            return false;
        }
        FinalClass c = (FinalClass) obj;
        return c.getKey().equals(this.getKey()) && c.getValue() == this.getValue() && c.getDate().equals(this.getDate());
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + value;
        result = result * prime + ((null == key) ? 0 : key.hashCode());
        result = result * prime + ((null == date) ? 0 : date.hashCode());
        return result;
    }
}

public class TestFinalClass {
    public static void main(String[] args) {
        FinalClass finalObj = new FinalClass("A", 65, new Date());
        System.out.println(finalObj.hashCode());
        finalObj.getDate().setTime(10000);
        System.out.println(finalObj.hashCode());
    }
}

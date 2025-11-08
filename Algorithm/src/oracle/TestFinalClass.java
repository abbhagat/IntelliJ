package oracle;

import java.util.Date;

record FinalClass(String key, int value, Date date) {

    @Override
    public Date date() {
        return (Date) this.date.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        FinalClass finalClass = (FinalClass) obj;
        return this.key().equals(finalClass.key()) && this.value() == finalClass.value && this.date().compareTo(finalClass.date()) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + this.value;
        hashCode = prime * hashCode + (this.key  == null ? 0 : this.key.hashCode());
        hashCode = prime * hashCode + (this.date == null ? 0 : this.date.hashCode());
        return hashCode;
    }

}

public class TestFinalClass {

    public static void main(String[] args) {
        FinalClass finalObj1 = new FinalClass("A", 65, new Date());
        FinalClass finalObj2 = new FinalClass("A", 65, new Date());
        System.out.println(finalObj1.hashCode());
        finalObj1.date().setTime(10000);
        System.out.println(finalObj1.hashCode());
        System.out.println(finalObj2.hashCode());
        finalObj2.date().setTime(10000);
        System.out.println(finalObj2.hashCode());
    }
}

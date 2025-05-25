package oracle;

import lombok.Getter;

import java.util.Date;
import java.util.Objects;

record FinalClass(@Getter String key, @Getter int value, Date date) {

    @Override
    public Date date() {
        return (Date) this.date.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || this.getClass() != obj.getClass()) {
            return false;
        }
        final FinalClass fcObj = (FinalClass) obj;
        return Objects.equals(this.key(), fcObj.key()) && this.value() == fcObj.value() && this.date().compareTo(fcObj.date()) == 0;
    }

    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + value;
        hashCode = prime * hashCode + (this.key()  == null ? 0 : this.key().hashCode());
        hashCode = prime * hashCode + (this.date() == null ? 0 : this.date().hashCode());
        return hashCode;
    }
}

public class TestFinalClass {

    public static void main(String[] args) {
        FinalClass finalObj = new FinalClass("A", 65, new Date());
        System.out.println(finalObj.hashCode());
        finalObj.date().setTime(10000);
        System.out.println(finalObj.hashCode());
    }
}

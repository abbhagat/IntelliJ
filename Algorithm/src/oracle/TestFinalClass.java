package oracle;

import lombok.Getter;

import java.util.Date;
import java.util.Objects;

final class FinalClass {

    @Getter
    private final String key;
    @Getter
    private final int value;
    private final Date date;

    public FinalClass(String key, int value, Date date) {
        this.key = key;
        this.value = value;
        this.date = date;
    }

    public Date getDate() {
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
        return Objects.equals(this.getKey(), fcObj.getKey()) && this.getValue() == fcObj.getValue() && this.getDate().compareTo(fcObj.getDate()) == 0;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        result = prime * result + (this.getKey()  == null ? 0 : this.getKey().hashCode());
        result = prime * result + (this.getDate() == null ? 0 : this.getDate().hashCode());
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

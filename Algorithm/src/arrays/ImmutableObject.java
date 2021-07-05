package arrays;

import java.util.Date;

final class Emp {

    private final Date date;

    public Emp(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return (Date) this.date.clone();
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (null == o || this.getClass() != o.getClass()) {
            return false;
        }
        final Emp obj = (Emp) o;
        return obj.getDate().compareTo(this.getDate()) == 0;
    }
}

public class ImmutableObject {
    public static void main(String[] args) {
        Emp e = new Emp(new Date());
        System.out.println(e.hashCode());
        Date d = e.getDate();
        d.setTime(1000);
        System.out.println(e.hashCode());
    }
}

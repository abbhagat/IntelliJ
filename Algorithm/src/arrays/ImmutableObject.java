package arrays;

import java.util.Date;

public class ImmutableObject {

    private static final class Emp {

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

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (null == obj || this.getClass() != obj.getClass()) {
                return false;
            }
            final Emp e = (Emp) obj;
            return e.getDate().compareTo(this.getDate()) == 0;
        }
    }

    public static void main(String[] args) {
        Emp e = new Emp(new Date());
        System.out.println(e.hashCode());
        Date d = e.getDate();
        d.setTime(1000);
        System.out.println(e.hashCode());
    }
}

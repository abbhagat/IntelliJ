package java8.optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private String name;

    @Override
    public String toString() {
        return getId() + " " + getName();
    }
}

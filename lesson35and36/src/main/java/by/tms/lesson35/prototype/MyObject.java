package by.tms.lesson35.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyObject {

    private String name;

    public MyObject copy() {
        return new MyObject(this.name);
    }
}

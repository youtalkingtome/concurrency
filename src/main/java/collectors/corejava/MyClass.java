package collectors.corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class MyClass {
    String name;
    MyClass(String name) { this.name = name; }

    public static void main(String[] args) {
        MyClass a = new MyClass("Alice");
        MyClass b = new MyClass("Alice");
        Map<MyClass, String> map = new HashMap<>();
        map.put(a, "Developer");
        System.out.println(map.get(b));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(name, myClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}



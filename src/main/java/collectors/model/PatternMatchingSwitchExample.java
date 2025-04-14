package collectors.model;

public class PatternMatchingSwitchExample {

    // A simple Point class
    static final class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        Object obj = new Point(3, 4);


    }
}
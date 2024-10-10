package collectors.model;

import collectors.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Optional;

@Getter
@Setter@AllArgsConstructor
public class Person {

    static String readLine(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    static void copy(String src, String dest) throws IOException {
        try (InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest)) {
                byte[] buff = new byte[100000];
                int n;
                while ((n = in.read(buff)) >= 0)
                    out.write(buff, 0, n);
            }
        }


    private Optional<Car> car;
    public Optional<Car> getCar() { return car; }
}

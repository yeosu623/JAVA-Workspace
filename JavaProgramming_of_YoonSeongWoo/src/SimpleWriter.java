import java.io.*;

class SimpleWriter {
    public static void main(String[] args) {
        try(Writer out = new FileWriter("data.txt")) {
            out.write('B');
            out.write('한');
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOExample {
    public static void main(String[] args) {

        try {
            FileOutputStream out = new FileOutputStream("Myfile.txt", true);
            out.write(9);
            String hello = "Hello World";
            byte b[] = hello.getBytes();
            out.write(b, 4, 7);
            out.close();

            FileInputStream in = new FileInputStream("Myfile.txt");
            int value;
            while ((value = in.read()) != -1) {
                System.out.print((char) value);
            }
            in.close();
            System.out.println();

            DataOutputStream dout = new DataOutputStream(new FileOutputStream("Myfile2.txt", true));
            dout.writeInt(45);
            dout.writeDouble(9.9);
            dout.writeUTF("hello");
            dout.writeBoolean(true);
            dout.writeInt(55);
            dout.writeDouble(78.9);
            dout.writeUTF("bye");
            dout.writeBoolean(false);
            dout.close();

            DataInputStream din = new DataInputStream(new FileInputStream("Myfile2.txt"));
            System.out.println(din.readInt());
            System.out.println(din.readDouble());
            System.out.println(din.readUTF());
            System.out.println(din.readBoolean());
            System.out.println(din.readInt());
            System.out.println(din.readDouble());
            System.out.println(din.readUTF());
            System.out.println(din.readBoolean());
            din.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
/**
 * @author boyerchris
 */
public class ProductGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<Product> listOne = new ArrayList<>();

        String iD = "";
        String name = "";
        String description = "";

        double cost = 0;

        boolean done = false;


        do {
            iD = SafeInput.getNonZeroLenString(in, "Please enter a 6 digit ID (000001, 000002, Etc)");
            name = SafeInput.getNonZeroLenString(in, "Please enter your product name");
            description = SafeInput.getNonZeroLenString(in, "Please enter your product description");
            cost = SafeInput.getDouble (in, "Please enter your product cost");


            Product record = new Product(iD, name, description, cost);
            listOne.add(record);


            done = SafeInput.getYNConfirm(in, "Are you finished entering product data?");

        }while (!done);

        File ProductData = new File(System.getProperty("user.dir"));
        Path file = Paths.get (ProductData.getPath() + "\\src\\ProductData.csv");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for (Product p : listOne) {
                writer.write(p.toString());
                writer.newLine();
            }
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
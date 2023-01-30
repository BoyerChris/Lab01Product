import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader
{

    public static void main(String[] args)
    {
        ArrayList<Product> listOne = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        String iD = "";
        String name = "";
        String description = "";
        String data = "";

        double cost = 0;




        try
        {
            File ProductData = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(ProductData);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));



                System.out.printf(" %-10s  %-10s  %-10s  %-10s", "ID#", "Name", "Description", "Cost");
                System.out.printf("%n===============================================%n");

                while (reader.ready())
                {
                    data = reader.readLine();
                    String[] arrOfdata = data.split(", ", 6);

                    iD = arrOfdata[0];
                    name = arrOfdata[1];
                    description = arrOfdata[2];
                    cost = Double.parseDouble(arrOfdata[3]);


                    Product record = new Product(iD, name, description, cost);
                    listOne.add(record);




                }
                for (Product p : listOne)
                {
                    System.out.printf(" %-10s  %-10s  %-10s  %-10s%n", p.getID(), p.getName(), p.getDescription(), p.getCost());
                }

                reader.close();


                System.out.println("\n\nfile read");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }





    }

}

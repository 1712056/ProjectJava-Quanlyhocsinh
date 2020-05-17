import java.nio.file.LinkPermission;
import java.util.*;
import java.io.*;

public class Quanlyhs extends ListStudent {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> danhsachHS = new ArrayList<>();
        int choose;
        Scanner input = new Scanner( System.in );
        boolean flag = true;
        do{

            while (flag==true){
                showMenu();
                System.out.print("Nhap lua chon:");
                choose = Integer.parseInt(input.nextLine());
                if(choose>=1 && choose <=7)
                {
                    switch (choose){
                        case 1:
                            Student hs = new Student();
                            hs.Nhap();
                            danhsachHS.add(hs);
                            myPrint("Them hoc sinh thanh cong!");
                            break;
                        case 2:
                            updateInfo(danhsachHS);
                            myPrint("Cap nhat thong tin hoc sinh thanh cong");
                            break;
                        case 3:
                            removeStudent(danhsachHS);
                            myPrint("Xoa hoc sinh thanh cong!");
                            break;
                        case 4:
                            danhsachHS = readFile();
                            showListStudent(danhsachHS);
                            break;
                        case 5:
                            danhsachHS = importFile();
                            myPrint("Import thanh cong!");
                            break;
                        case 6:
                            exportFile(danhsachHS);
                            myPrint("Export thanh cong!");
                            break;
                        case 7:
                            flag=false;
                            break;
                    }
                    writeFile(danhsachHS);
                }
                else {
                    myPrint("Nhap sai moi nhap lai");
                }
            }
        }while(flag==true);
    }

    //doc file nhi phan
    public static ArrayList<Student> readFile() throws IOException
    {
        ArrayList<Student> dshs = new ArrayList<>();
        ObjectInputStream ObjInput = null;

        try {
            ObjInput = new ObjectInputStream(new FileInputStream("./danhsachhocsinh.txt"));
        }
        catch(IOException exc)
        {
            System.out.println("Error open file.");
        }
        try
        {
            dshs = (ArrayList<Student>) ObjInput.readObject();
        }
        catch(IOException | ClassNotFoundException exc)
        {
            System.out.println("Error reading file.");
        }
        finally {
            if(ObjInput != null)
            {
                ObjInput.close();
            }
        }
        return dshs;
    }
    //ghi file nhi phan
    public static void writeFile(ArrayList<Student> dshs) throws IOException
    {
        ObjectOutputStream ObjOutput = null;
        try
        {
            ObjOutput = new ObjectOutputStream(new FileOutputStream("./danhsachhocsinh.txt")) ;
        }
        catch(IOException exc)
        {
            System.out.println("Error open file !");
            return;
        }

        try
        {
            ObjOutput.writeObject(dshs);
        }
        catch(IOException exc)
        {
            System.out.println("Error write file.");
        }
        finally {
            if (ObjOutput != null) {
                ObjOutput.close();
            }
        }
    }
    //import tu file csv
    public  static ArrayList<Student> importFile() throws IOException
    {
        ArrayList<Student> dshs = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try{
            FileReader fr = new FileReader("./danhsachhocsinh.csv");
            bufferedReader = new BufferedReader(fr);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                long studentID = Long.parseLong(temp[0]);
                String firstName = temp[1];
                float point = Float.parseFloat(temp[2]);
                String address = temp[3];
                String notes= temp[4];
                dshs.add(new Student(studentID, firstName, point, address, notes));
            }
        }catch (IOException exc)
        {
            System.out.println("Error open file.");
        }
        bufferedReader.close();
        return dshs;
    }
    //export tu file csv
    public static void exportFile(ArrayList<Student> dshs) throws IOException
    {
        BufferedWriter bufferedWriter = null;
        try{
            FileWriter fw = new FileWriter("./danhsachhocsinh.csv");
            bufferedWriter = new BufferedWriter(fw);

        }catch(IOException exc)
        {
            System.out.println("Error open file !");
            return;
        }
        try{
            for(Student stu : dshs)
            {
                bufferedWriter.write(Long.toString(stu.getMHS()));
                bufferedWriter.write(",");
                bufferedWriter.write(stu.getTenHS());
                bufferedWriter.write(",");
                bufferedWriter.write(Float.toString(stu.getDiem()));
                bufferedWriter.write(",");
                bufferedWriter.write(stu.getDiachi());
                bufferedWriter.write(",");
                bufferedWriter.write(stu.getGhichu());
                bufferedWriter.write("\n");
            }
        }catch (IOException exc)
        {
            System.out.println("Error write file !");
            return;
        }
        finally {
            bufferedWriter.close();
        }
    }
}


//nguồn tham khảo:https://stackoverflow.com/questions/49599194/reading-csv-file-into-an-arrayliststudent-java
//https://stackoverflow.com/questions/46702138/write-data-to-csv-from-two-arraylist/46702698
//https://viettuts.vn/java-collection/sorting-trong-collections#goto-h2-2
//https://viettuts.vn/java-io/lop-objectinputstream-trong-java
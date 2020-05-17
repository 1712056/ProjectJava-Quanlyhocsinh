import java.util.*;
public class ListStudent {
    //ham in chuoi
    public static void myPrint(String content){
        System.out.println(content);
    }
    //hien thi menu lua chon
    public static void showMenu(){
        myPrint("CHUONG TRINH QUAN LY HOC SINH");
        myPrint("1. Them hoc sinh");
        myPrint("2. Cap nhat thong tin hoc sinh");
        myPrint("3. Xoa hoc sinh");
        myPrint("4. Xem danh sach hoc sinh");
        myPrint("5. Import danh sach hoc sinh tu file text(csv)");
        myPrint("6. Export danh sach hoc sinh ra file text(csv)");
        myPrint("7. Thoat chuong trinh");
        myPrint("");
    }
    //xem danh sach hoc sinh
    public static void showListStudent(ArrayList<Student> dshs)
    {
        if(dshs.size()!= 0)
        {
            Scanner input = new Scanner(System.in);

            int choose;
            boolean flag=true;
            do {
                myPrint("(1). MHS tang dan");
                myPrint("(2). MHS giam dan");
                myPrint("(3). Diem tang dan");
                myPrint("(4). Diem giam dan");
                System.out.print("Nhap lua chon:");
                choose = Integer.parseInt(input.nextLine());
                switch (choose)
                {
                    case 1:
                        sortListStudentbyMHsASC(dshs);
                        break;
                    case 2:
                        sortListStudentbyMHsDESC(dshs);
                        break;
                    case 3:
                        sortListStudentbyPointASC(dshs);
                        break;
                    case 4:
                        sortListStudentbyPointDESC(dshs);
                        break;
                }
                flag=false;
            }while(flag==true);
            myPrint("----------------------------------------------------DANH SACH HOC SINH----------------------------------------------------");
            System.out.format("%10s | ", "MHS");
            System.out.format("%20s | ", "HO VA TEN");
            System.out.format("%10s | ", "DIEM");
            System.out.format("%30s | ", "DIA CHI");
            System.out.format("%40s\n", "GHI CHU");
            myPrint("--------------------------------------------------------------------------------------------------------------------------");
            for (Student stu : dshs) {
                System.out.format("%10s | ", stu.getMHS());
                System.out.format("%20s | ", stu.getTenHS());
                System.out.format("%10s | ", stu.getDiem());
                System.out.format("%30s | ", stu.getDiachi());
                System.out.format("%40s\n", stu.getGhichu());
            }
        }
        else{
            myPrint("DANH SACH RONG!");
        }
    }
    //sap xep danh sach sinh vien tang dan theo MHS
    public static void sortListStudentbyMHsASC(ArrayList<Student> dshs)
    {
        Collections.sort(dshs, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getMHS()>o2.getMHS()?1:-1;
            }
        });
    }
    //sap xep danh sach sinh vien giam dan theo MHS
    public static void sortListStudentbyMHsDESC(ArrayList<Student> dshs)
    {
        Collections.sort(dshs, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getMHS()>o2.getMHS()?-1:1;
            }
        });
    }
    //sap xep danh sach sinh vien tang dan theo Diem
    public static void sortListStudentbyPointASC(ArrayList<Student> dshs)
    {
        Collections.sort(dshs, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getDiem()>o2.getDiem()?1:-1;
            }
        });
    }
    //sap xep danh sach sinh vien giam dan theo Diem
    public static void sortListStudentbyPointDESC(ArrayList<Student> dshs)
    {
        Collections.sort(dshs, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getDiem()>o2.getDiem()?-1:1;
            }
        });
    }
    //cap nhat thong tin hoc sinh
    public static void updateInfo(ArrayList<Student> dshs)
    {
        Scanner input = new Scanner(System.in);
        int MaHS;
        boolean flag=true;
        do {
            System.out.print("Nhap ma hoc sinh can cap nhat:");
            MaHS = Integer.parseInt(input.nextLine());
            for (int i=0;i<dshs.size();i++) {
                if (dshs.get(i).getMHS() == MaHS)
                {
                    dshs.get(i).toString();

                    int choose;
                    do {
                        myPrint("(1). Sua ten");
                        myPrint("(2). Sua diem");
                        myPrint("(3). Sua dia chi");
                        myPrint("(4). Sua ghi chu");
                        myPrint("(5). Thoat");
                        System.out.print("Nhap lua chon:");
                        choose = Integer.parseInt(input.nextLine());
                        String temp;
                        Float diemtemp;
                        switch (choose) {
                            case 1:
                                System.out.print("Nhap ten hoc sinh:");
                                temp = input.nextLine();
                                dshs.get(i).setTenHS(temp);
                                break;
                            case 2:
                                System.out.print("Nhap diem hoc sinh: ");
                                while (!dshs.get(i).setDiem(input.nextFloat())) ;
                                break;
                            case 3:
                                System.out.print("Nhap dia chi hoc sinh:");
                                temp = input.next();
                                dshs.get(i).setDiachi(temp);
                                break;
                            case 4:
                                System.out.print("Nhap ghi chu:");
                                temp = input.next();
                                dshs.get(i).setGhichu(temp);
                                break;
                            case 5:
                                flag = false;
                                break;
                        }
                    } while (flag == true);
                    showListStudent(dshs);
                    break;
                }
                if(flag==true&&i==dshs.size()-1)
                {
                    flag=false;
                    myPrint("MA HOC SINH KHONG TON TAI!");
                }
            }
        }while (flag==true);
        return;
    }
    //xoa hoc sinh
    public static void removeStudent(ArrayList<Student> dshs)
    {
        Scanner input = new Scanner(System.in);
        int MaHS;
        boolean flag=true;
        do {
            System.out.print("Nhap ma hoc sinh can xoa:");
            MaHS = Integer.parseInt(input.nextLine());
            for (int i=0;i<dshs.size();i++) {
                if (dshs.get(i).getMHS() == MaHS)
                {
                    dshs.remove(i);
                    flag=false;
                    break;
                }
                if(flag==true&&i==dshs.size()-1)
                {
                    flag=false;
                    myPrint("MA HOC SINH KHONG TON TAI!");
                }
            }
        }while (flag==true);
        return;
    }

}

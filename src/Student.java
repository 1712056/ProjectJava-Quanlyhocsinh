import java.io.Serializable;
import java.util.*;
public class Student implements Serializable {
    private long MHS;//ma hoc sinh
    private String TenHS;
    private float Diem;
    private String Diachi;
    private String Ghichu;

    public long getMHS() {
        return MHS;
    }

    public void setMHS(long MHS) {
        this.MHS = MHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public void setTenHS(String tenHS) {
        TenHS = tenHS;
    }

    public float getDiem() {
        return Diem;
    }

    public boolean setDiem(float diem) {
        if(diem>=0.0 && diem <=10.0)
        {
            Diem = diem;
            return true;
        }
        else
        {
            System.err.println("Nhap sai diem moi nhap lai!");
            return false;
        }
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String ghichu) {
        Ghichu = ghichu;
    }
    //nhap thong tin hoc sinh

    public void Nhap()
    {
        Scanner input = new Scanner( System.in );
        System.out.print("Nhap MHS: ");
        MHS = input.nextInt();
        System.out.print("Nhap Ho va Ten: ");
        input.nextLine();
        TenHS = input.nextLine();
        System.out.print("Nhap Diem: ");
        while (!setDiem(input.nextFloat()));
        input.nextLine();
        System.out.print("Nhap Dia chi: ");
        Diachi = input.nextLine();
        System.out.print("Nhập ghi chu: ");
        Ghichu = input.nextLine();
    }
    @Override
    public String toString() {
        return "Student{" +
                "MHS=" + MHS +
                ", TenHS='" + TenHS + '\'' +
                ", Diem=" + Diem +
                ", Diachi='" + Diachi + '\'' +
                ", Ghichu='" + Ghichu + '\'' +
                '}'+"\n";
    }

    public Student() {
    }

    public Student(long MHS, String tenHS, float diem, String diachi, String ghichu) {
        this.MHS = MHS;
        TenHS = tenHS;
        Diem = diem;
        Diachi = diachi;
        Ghichu = ghichu;
    }
}

package automation.testsuite;

import org.testng.annotations.Test;

public class BTVN_Day7 {
    @Test
    public void NhanVien(){
        NhanVien[] danhSach = new NhanVien[] {
                new NhanVien("An"),
                new NhanVien("Bình"),
                new NhanVien("Cường")
        };

        System.out.println("Danh sách nhân viên:");
        for (NhanVien nv : danhSach) {
            System.out.println("- " + nv.getTen());
        }

    }
}

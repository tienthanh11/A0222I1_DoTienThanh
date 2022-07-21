package ThiModule2.service;

import ThiModule2.model.DanhBa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhBaService {

    static Scanner scanner = new Scanner(System.in);
    private List<DanhBa> danhBas = new ArrayList<>();

    public DanhBaService() {
    }

    public void create(DanhBa danhBa) {
        danhBas.add(danhBa);
    }

    public List<DanhBa> findAll() {
        return danhBas;
    }


    public void editProduct(String sdtEdit) {
        for(int i = 0; i < danhBas.size(); i++) {
            if(danhBas.get(i).getSoDienThoai().equals(sdtEdit)) {
                System.out.println("Nhập nhóm muốn sửa: ");
                String editNhom = scanner.nextLine();
                danhBas.get(i).setNhom(editNhom);
                System.out.println("Nhập tên muốn sửa: ");
                String editName = scanner.nextLine();
                danhBas.get(i).setName(editName);
                System.out.println("Nhập giới tính muốn sửa: ");
                String editGioiTinh = scanner.nextLine();
                danhBas.get(i).setGioiTinh(editGioiTinh);
                System.out.println("Nhập địa chỉ muốn sửa: ");
                String editDiaChi = scanner.nextLine();
                danhBas.get(i).setDiaChi(editDiaChi);
                System.out.println("Nhập ngày sinh muốn sửa: ");
                String editNgaySinh = scanner.nextLine();
                danhBas.get(i).setNgaySinh(editNgaySinh);
                System.out.println("Nhập email muốn sửa: ");
                String editEmail = scanner.nextLine();
                danhBas.get(i).setEmail(editEmail);
            } else {
                System.out.println("Không tìm được danh ba với số điện thoại trên.");
            }
        }
    }

    public void delete(String sdtDelete) {
        for(int i = 0; i < danhBas.size(); i++) {
            if(danhBas.get(i).getSoDienThoai().equals(sdtDelete)) {
                danhBas.remove(i);
                return;
            }
        }
    }

    public List<DanhBa> search(String name) {
        List<DanhBa> result = new ArrayList<>();

        for (DanhBa danhBa : danhBas) {
            if (danhBa.getName().contains(name)) {
                result.add(danhBa);
            }
        }
        return result;
    }

}

package BaiTap.Bai2_HospitalManagement.service;

import BaiTap.Bai2_HospitalManagement.util.NotFoundMedicalRecordException;

public interface BenhAnThuongService {
    void display();
    void addNew();
    void delete() throws NotFoundMedicalRecordException;
}

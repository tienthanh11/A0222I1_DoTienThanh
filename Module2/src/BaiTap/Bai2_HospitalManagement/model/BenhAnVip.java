package BaiTap.Bai2_HospitalManagement.model;

public class BenhAnVip extends BenhAn {
    private String loaiVip;
    private String thoiHanVip;

    public BenhAnVip() {
    }

    public BenhAnVip(String soThuTu, String maBenhAn, String tenBenhNhan, String ngayNhapVien, String ngayRaVien,
                     String lyDoNhapVien, String loaiVip, String thoiHanVip) {
        super(soThuTu, maBenhAn, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    public String getInfoBenhAn(){
        return this.getSoThuTu() + "," +
                this.getMaBenhAn() + "," +
                this.getTenBenhNhan() + ","+
                this.getNgayNhapVien() + ","+
                this.getNgayRaVien()+ "," +
                this.getLyDoNhapVien()+ "," +
                this.getLoaiVip() + "," +
                this.getThoiHanVip();
    }
}

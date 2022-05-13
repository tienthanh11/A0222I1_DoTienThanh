class Mobile {
    constructor(namePhone) {
        this.namePhone = namePhone;
        this.tinNhanDangSoanThao = new Array();
        this.tinNhanTrongHopThuDen = new Array();
        this.tinNhanDaGui = new Array();
    }
    getNamePhone() {
        return this.namePhone;
    }
    setPin(pin) {
        this.pin = pin;
    }
    getPin() {
        return this.pin;
    }
    getTinNhanDangSoanThao() {
        return this.tinNhanDangSoanThao;
    }
    getTinNhanTrongHopThuDen() {
        return this.tinNhanTrongHopThuDen;
    }
    getTinNhanDaGui() {
        return this.tinNhanDaGui;
    }
    setStatusPhone(statusPhone) {
        this.statusPhone = statusPhone;
    }
    getStatusPhone() {
        return this.statusPhone;
    }
    checkStatusPhone() {
        if(this.statusPhone === true) {
            return "Trạng thái điện thoại đang bật";
        } else {
            return "Trạng thái điện thoại đang tắt";
        }
    }
    batPhone() {
        this.pin--;
        this.setStatusPhone(true);
    }
    tatPhone() {
        this.pin--;
        this.setStatusPhone(false);
    }
    sacPinPhone() {
        let str = " ";
        for(let i = this.pin; i <= 100; i++) {
            this.setPin(i);
            str += ":" + i;
        }
        return str;
    }
    soanTinNhan(noiDung) {
        this.tinNhanDangSoanThao.push(noiDung);
        this.pin--;
    }
    nhanTinNhan() {
        this.pin--;
        return this.tinNhanTrongHopThuDen;
    }
    guiTinNhan(arr) {
        for(let i = 0; i < this.tinNhanDangSoanThao.length; i++) {
            this.tinNhanDaGui.push(this.tinNhanDangSoanThao[i]);
            arr.tinNhanTrongHopThuDen.push(this.tinNhanDangSoanThao[i]);
        }
        this.tinNhanDangSoanThao = new Array();
        this.pin--;
    }
    xemTinNhanDen() {
        this.pin--;
        return "Có " + this.getTinNhanTrongHopThuDen().length + " tin nhắn đến: " + this.getTinNhanTrongHopThuDen().join();
    }
    xemTinNhanDaGui() {
        this.pin--;
        return "Có " + this.getTinNhanDaGui().length + " tin nhắn đến: " + this.getTinNhanDaGui().join();
    }
    displayInit() {
        return "Bạn đã khởi tạo 1 chiếc điện thoại " + this.getNamePhone();
    }
}
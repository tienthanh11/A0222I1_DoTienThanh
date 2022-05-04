let nokia = new Mobile('nokia');
let statusPin1 = document.getElementById('trangthaipin1');
let sacPin1 = document.getElementById('sacpin1');
let nhapTin1 = document.getElementById('nhaptin1');
let resultNokia = document.getElementById('result1');
let massageDangSoan1 = document.getElementById('tinnhandangsoanthao1');
let massageTrongHopThuDen1 = document.getElementById('tinnhantronghopthuden1');
let massageDaGui1 = document.getElementById('tinnhandagui1');
displayInit(nokia);
nokia.setPin(0);
displayPin(nokia);

let iphone = new Mobile('iphone');
let statusPin2 = document.getElementById('trangthaipin2');
let sacPin2 = document.getElementById('sacpin2');
let nhapTin2 = document.getElementById('nhaptin2');
let resultIphone = document.getElementById('result2');
let massageDangSoan2 = document.getElementById('tinnhandangsoanthao2');
let massageTrongHopThuDen2 = document.getElementById('tinnhantronghopthuden2');
let massageDaGui2 = document.getElementById('tinnhandagui2');
displayInit(iphone);
iphone.setPin(0);
displayPin(iphone);

function displayInit(element) {
    switch (element.getNamePhone()) {
        case "nokia":
            resultNokia.innerText = element.displayInit();
            break;
        case "iphone" :
            resultIphone.innerText = element.displayInit();
            break;
    }
}

function displayPin(element) {
    switch (element.getNamePhone()) {
        case "nokia":
            statusPin1.innerText = "Trạng thái pin: " + element.getPin();
            break;
        case "iphone":
            statusPin2.innerText = "Trạng thái pin: " + element.getPin();
            break;
    }
}

function sacPin(namePhone) {
    switch (namePhone) {
        case "nokia":
            sacPin1.innerText = "Đang sạc điện thoại " + nokia.sacPinPhone();
            break;
        case "iphone":
            sacPin2.innerText = "Đang sạc điện thoại " + iphone.sacPinPhone();
            break;
    }
}

function turnOnPhone(namePhone) {
    switch (namePhone) {
        case "nokia":
            nokia.batPhone();
            resultNokia.innerText = nokia.checkStatusPhone();
            displayPin(nokia);
            break;
        case "iphone":
            iphone.batPhone();
            resultIphone.innerText = iphone.checkStatusPhone();
            displayPin(iphone);
            break;
    }
}

function turnOffPhone(namePhone) {
    switch (namePhone) {
        case "nokia":
            nokia.tatPhone();
            resultNokia.innerText = nokia.checkStatusPhone();
            displayPin(nokia);
            break;
        case "iphone":
            iphone.tatPhone();
            resultIphone.innerText = iphone.checkStatusPhone();
            displayPin(iphone);
            break;
    }
}

function soanMessage(namePhone) {
    switch (namePhone) {
        case "nokia":
            if(nokia.getStatusPhone() === true) {
                nokia.soanTinNhan(nhapTin1.value);
                massageDangSoan1.innerText = nokia.getTinNhanDangSoanThao().join();
                nhapTin1.value = "";
                displayPin(nokia);
            } else {
                alert("Điện thoại của bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
        case "iphone":
            if(iphone.getStatusPhone() === true) {
                iphone.soanTinNhan(nhapTin2.value);
                massageDangSoan2.innerText = nokia.getTinNhanDangSoanThao().join();
                nhapTin2.value = "";
                displayPin(iphone);
            } else {
                alert("Điện thoại của bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
    }
}

function guiMessage(namePhone) {
    switch (namePhone) {
        case "nokia":
            if(iphone.getStatusPhone() === true) {
                iphone.guiTinNhan(nokia);
                massageDaGui2.innerText = iphone.getTinNhanDaGui().join();
                displayPin(iphone);
                resultIphone.innerText = "iPhone đã gửi đến nokia tin nhắn '" + iphone.getTinNhanDaGui().join() + "'thành công";
            } else {
                alert("Điện thoại bạn chưa bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
        case "iphone":
            if(nokia.getStatusPhone() === true) {
                nokia.guiTinNhan(iphone);
                massageDaGui1.innerText = nokia.getTinNhanDaGui().join();
                displayPin(nokia);
                resultNokia.innerText = "Nokia đã gửi đến iPhone tin nhắn '" + nokia.getTinNhanDaGui().join() + "' thành công";
            } else {
                alert("Điện thoại bạn chưa bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
    }
}

function xemMessage(namePhone) {
    switch (namePhone) {
        case "nokia":
            if(nokia.getStatusPhone() === true) {
                resultNokia.innerText = nokia.xemTinNhanDen();
                resultNokia.innerText = nokia.xemTinNhanDaGui();
                displayPin(nokia);
            } else {
                alert("Điện thoại bạn chưa bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
        case "iphone":
            if(iphone.getStatusPhone() === true) {
                resultIphone.innerText = iphone.xemTinNhanDen();
                resultIphone.innerText = iphone.xemTinNhanDaGui();
                displayPin(iphone);
            } else {
                alert("Điện thoại bạn chưa bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
    }
}

function nhanMessage(namePhone) {
    switch (namePhone) {
        case "nokia":
            if(nokia.getStatusPhone() === true) {
                massageTrongHopThuDen1.innerText = nokia.nhanTinNhan().join();
                displayPin(nokia);
            } else {
                alert("Điện thoại bạn chưa bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
        case "iphone":
            if(iphone.getStatusPhone() === true) {
                massageTrongHopThuDen2.innerText = iphone.nhanTinNhan().join();
                displayPin(iphone);
            } else {
                alert("Điện thoại bạn chưa bật!!! Vui lòng bật điện thoại mới có thể dùng được");
            }
            break;
    }
}
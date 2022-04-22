class Apple {
    constructor(weight) {
        this.weight = weight;
    }
    getWeight() {
        return this.weight;
    }
    decrease() {
        this.weight--;
    }
    isEmpty() {
        if(this.getWeight() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
class Human {
    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }
    getName() {
        return this.name;
    }
    setGender(gender) {
        this.gender = gender;
    }
    getGender() {
        return this.gender;
    }
    setWeight(weight) {
        this.weight = weight;
    }
    getWeight() {
        return this.weight;
    }

    checkGender() {
        if(this.gender === true) {
            return "Giới tính nam";
        } else {
            return "Giới tính nữ";
        }
    }
    isMale() {
        return this.gender = true;
    }
    isFemale() {
        return this.gender = false;
    }
    eatApple() {
        if(apple.getWeight() > 0) {
            this.weight++;
            apple.decrease();
        } else {
            return 0;
        }
    }
    say(mess) {
        return mess;
    }
    kiemTraApple() {
        return apple.getWeight();
    }
}
let adam = new Human("adam", 65);
let eva = new Human("eva", 48);
let apple = new Apple(10);

function goiTen(name) {
    switch (name) {
        case adam:
            document.write("Tôi tên là: " + adam.getName());
            break;
        case eva:
            document.write("Tôi tên là: " + eva.getName());
            break;
    }
}
function goiGioiTinh(name) {
    switch (name) {
        case adam:
            document.write(adam.checkGender());
            break;
        case eva:
            document.write(adam.checkGender());
            break;
    }
}

function chaoHoi(name) {
    switch (name) {
        case adam:
            document.write(adam.say("Adam xin chào tất cả mọi người"));
            break;
        case eva:
            document.write(eva.say("Eva xin chào tất cả mọi người"));
            break;
    }
}
function canNang(name) {
    switch (name) {
        case adam:
            document.write("Tôi nặng " + adam.getWeight() + " kí");
            break;
        case eva:
            document.write("Tôi nặng " + eva.getWeight() + " kí");
            break;
    }
}
function donViApple() {
    document.write("Số quả táo là: " + apple.getWeight());
}
function kiemTraApple(name) {
    switch (name) {
        case adam:
            document.write("Số táo là:" + adam.kiemTraApple());
            break;
        case eva:
            document.write("Số táo là: " + eva.kiemTraApple());
            break;
    }
}
function anApple(name) {
    switch (name) {
        case adam:
            if(apple.isEmpty()) {
                document.write("Cân nặng là:" + adam.getWeight() + "<br> Khối lượng táo là: " + apple.getWeight());
            } else {
                document.write("Hết táo rồi.");
            }
            break;
        case eva:
            if(apple.isEmpty()) {
                document.write("Cân nặng là:" + eva.getWeight() + "<br> Khối lượng táo là: " + apple.getWeight());
            } else {
                document.write("Hết táo rồi.");
            }
            break;
    }
}



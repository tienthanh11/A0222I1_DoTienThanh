class Hero {
    constructor(image, top, left, size) {
        this.image = image;
        this.top = top;
        this.left = left;
        this.size = size;
    }
    getHeroElement() {
        return '<img width="'+ this.size + '"' +
            ' height="'+ this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: '+ this.top+'px; left:'+this.left + 'px; position:absolute;" />';
    }
    moveRight() {
        this.left += 20;
        console.log("ok: " + this.left);
    }
    moveBottom() {
        this.top += 20;
        console.log("ok: " + this.top);
    }
    moveLeftNguoc() {
        this.left -= 20;
        console.log("ok: " + this.left);
    }
    moveTopNguoc() {
        this.top -= 20;
        console.log("ok: " + this.top);
    }
}

let hero = new Hero("doraemon.jpg", 20, 30, 200);
function start() {
    if(hero.left < window.innerWidth - hero.size && hero.top === 20) {
        hero.moveRight();
    } else if(hero.top < window.innerHeight - hero.size && hero.left > window.innerWidth - hero.size) {
        hero.moveBottom();
    } else if(hero.left > window.innerWidth - hero.size || hero.left > 20) {
        hero.moveLeftNguoc();
    } else {
        hero.moveTopNguoc();
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 50);
}
start();
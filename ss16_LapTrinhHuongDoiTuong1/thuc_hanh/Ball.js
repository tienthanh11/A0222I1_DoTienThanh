/*function Ball(mapWidth, mapHeight) {
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
    this.radius = 20;
    this.x = 3;
    this.y = 3;

    this.cx = Math.floor(Math.random() * (this.mapWidth - 2 * this.radius)) + this.radius;
    this.cy = Math.floor(Math.random() * (this.mapHeight - 2 * this.radius)) + this.radius;
}
Ball.prototype.draw = function (alpha) {
    if(!alpha) {
        alpha = 25;
    }
    let context = document.getElementById("myCanvas");
    let ctx = context.getContext("2d");
    ctx.beginPath();
    ctx.fillStyle = "raba(255, 100, 100," + alpha + ")";
    ctx.arc(this.cx, this.cy, this.radius, 0, Math.PI * 2, true);
    ctx.closePath();
    ctx.fill();
}
Ball.prototype.move = function () {
    this.cx += this.x;
    this.cy += this.y;

    this.left = this.cx - this.radius;
    this.top = this.cy - this.radius;
    this.right = this.cx + this.radius;
    this.bottom = this.cy + this.radius;
}
Ball.prototype.checkCollision = function () {
    if(this.left <= 0 || this.right >= this.mapWidth) {
        this.x = - this.x;
    }
    if(this.top <= 0 || this.bottom >= this.mapHeight) {
        this.y = - this.y;
    }
}*/
class Ball {
    constructor(mapWidth, mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.radius = 20;
        this.x = 3;
        this.y = 3;

        this.cx = Math.floor(Math.random() * (this.mapWidth - 2 * this.radius) + this.radius);
        this.cy = Math.floor(Math.random() * (this.mapHeight - 2 * this.radius) + this.radius);
    }
    draw(alpha) {
        if(!alpha) {
            alpha = 25;
        }
        let context = document.getElementById("myCanvas");
        let ctx = context.getContext("2d");
        ctx.beginPath();
        ctx.fillStyle = "raba(255, 100, 100," + alpha + ")";
        ctx.arc(this.cx, this.cy, this.radius, 0, Math.PI * 2, true);
        ctx.closePath();
        ctx.fill();
    }
    move() {
        this.cx += this.x;
        this.cy += this.y;

        this.left = this.cx - this.radius;
        this.top = this.cy - this.radius;
        this.right = this.cx + this.radius;
        this.bottom = this.cy + this.radius;
    }
    checkCollision() {
        if(this.left <= 0 || this.right >= this.mapWidth) {
            this.x = - this.x;
        }
        if(this.top <= 0 || this.bottom >= this.mapHeight) {
            this.y = - this.y;
        }
    }
}

package TankGame2;

public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed = 1;

    public void setSpeed(int speed){
        this.speed = speed;
    }

    //移动方法
    public void moveUp(){
        y -= 1;
    }
    public void moveRight(){
        x += 1;
    }
    public void moveDown(){
        y += 1;
    }
    public void moveLeft(){
        x -= 1;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

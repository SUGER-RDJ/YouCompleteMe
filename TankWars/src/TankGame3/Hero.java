package TankGame3;

public class Hero extends Tank {

    //定义一个shout对象，表示一个射击（线程）
    Shot shot = null;
    public Hero(int x, int y) {
        super(x, y);
    }

    //射击
    public void shouEnemyTank(){
        //创建Shot对象，根据当前Hero的位置和方向创建shot
        switch (getDirection()){
            case 0:
                shot = new Shot(getX() + 20, getY(),0,3);
                break;
            case 1:
                shot = new Shot(getX(), getY() + 20,1,3);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60,2,3);
                break;
            case 3:
                shot = new Shot(getX() + 60, getY() + 20,3,3);
                break;
        }
        new Thread(shot).start();
    }

}

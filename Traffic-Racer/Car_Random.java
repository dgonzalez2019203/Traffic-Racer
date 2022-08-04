import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car_Random here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car_Random extends Actor
{
    
    private int speed;
    
    public Car_Random(int v){
        speed = v;
    }
    
    public void act()
    {
        setLocation(getX(), getY() + speed);
        if( getY() >= getWorld().getHeight() - 1 ){
            MyWorld play = (MyWorld) getWorld();
            play.removeObject(this);
            play.increase_score(10);
            play.decrease_rivals();
            play.increase_delays();
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_One here.
 * 
 * @author (Diego) 
 * @version (a version number or a date)
 */
public class Player_One extends Actor
{    
    private int speed = 5;
    
    public Player_One(int v){
        speed = v;
    }
    
    public void act()
    {                            
        if(Greenfoot.isKeyDown("right")){
            if(getX() < 460){
                setLocation(getX() + speed, getY());
            }            
        }
        
        if(Greenfoot.isKeyDown("left")){
            if(getX() > 140){
                setLocation(getX() - speed, getY());
            }            
        }
        
        if(Greenfoot.isKeyDown("up")){
            if(getY() > 300){
                setLocation(getX(), getY() - speed);
            }            
        }
        
        if(Greenfoot.isKeyDown("down")){
            if(getY() < 640){
                setLocation(getX(), getY() + speed);
            }            
        }   
        
        checkCollision();
    }
    
    public void checkCollision(){
        Actor collided = getOneIntersectingObject(Car_Random.class);

        if (collided != null)
        {
          getWorld().removeObject(collided);
          getWorld().removeObject(this);
          Greenfoot.stop();
        }
    }    
    
    public void aumenta_velocidad(){
        speed++;
    }
}

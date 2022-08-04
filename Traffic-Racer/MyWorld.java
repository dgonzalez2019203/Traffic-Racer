import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    private counter score;
    private counter level;
    
    private int velocidad_coche;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private Player_One playerOne;
    private int num_rivales;
    
    public MyWorld()
    {    

        super(600, 700, 1);
        
        num_adelantamientos = 0;
       num_adelantamientos_nivel = 4;
       velocidad_coche = 2;
       
       score = new counter("Nivel de Alcohol: " );
       level = new counter("");
       level.add(1);
       playerOne = new Player_One(velocidad_coche);
       
       addObject(playerOne, 300, 600);
       addObject(score, 205, 60);
    }
    
    public void act(){
        add_difficulty();
        put_car_random();
    }
    
    public int getRandomNumber(int start,int end){
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    public void increase_score(int valor){
        score.add(valor);
    }
    
    public void increase_delays(){
        num_adelantamientos++;
    }
    
    public void decrease_rivals(){
        num_rivales--;
    }
    
    
    public void add_difficulty(){
        if(num_adelantamientos == num_adelantamientos_nivel){
            num_adelantamientos = 0;
            num_adelantamientos_nivel = num_adelantamientos_nivel + 2;
            velocidad_coche++;
            level.add(1);
            playerOne.aumenta_velocidad();
        }
    }
   
    public void put_car_random(){
        
        if(num_rivales == 0){
            
            int carril = getRandomNumber(0,3);
            
            if(carril == 0){
                addObject(new Car_Random(velocidad_coche),180, 80);
            }
            else if( carril == 1){
                addObject(new Car_Random(velocidad_coche),290, 80);
            }
            else{
                addObject(new Car_Random(velocidad_coche),410, 80);
            }
            
            carril++;
            carril = carril % 3;
            
            if(carril == 0){
                addObject(new Car_Random(velocidad_coche),180, 80);
            }
            else if( carril == 1){
                addObject(new Car_Random(velocidad_coche),290, 80);
            }
            else{
                addObject(new Car_Random(velocidad_coche),410, 80);
            }
            
            
            num_rivales = 2;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

import static java.lang.StrictMath.max;
import java.util.Random;
import static project.hunt_or_be_hunted.GUIController.Animals;
import static project.hunt_or_be_hunted.GUIController.draw;
import static project.hunt_or_be_hunted.GUIController.getEnviromentByCoordinate;

/**
 *
 * @author filip
 */
public class Prey extends Animal implements Runnable {

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    private float water_level;
    private float food_level;
    private int x;
    private int y;
    private int age;

    public Prey(String _name, float _health, float _speed, float _strength, String _spiece, float _water_level, float _food_level, int _x, int _y) {
        super(_name, _health, _speed, _strength, _spiece);
        water_level = _water_level;
        food_level = _food_level;
        x = _x;
        y = _y;
        age = 0;
    }
    public synchronized void drink(Water_source a) throws InterruptedException{
        if (a.getResource() < 100 - water_level){
            water_level += a.getResource();
            a.setResource(0);
        }
        else{
            a.setResource((int) (a.getResource() - water_level));
            water_level = 100;
        }
        Thread.sleep(1000);
    }
    public synchronized void feed(Food_source a) throws InterruptedException{
        if (a.getResource() < 100 - food_level){
            food_level += a.getResource();
            a.setResource(0);
        }
        else{
            a.setResource((int) (a.getResource() - food_level));
            food_level = 100;
        }
        Thread.sleep(1000);
    }
    
    public synchronized void move(int dest_x, int dest_y){
            if (GUIController.FreeSpace(dest_x, dest_y)){
                GUIController.animal_moves(dest_x, dest_y, x, y);
                setX(dest_x);
                setY(dest_y);
            }
    }
    public synchronized void reproduce(int x, int y){
        Prey ani = new Prey(getName(), max(new Random().nextInt(20)-10+getHealth(), 10), (float) max((float) (new Random().nextInt(4)*0.5)-1+getSpeed(), 0.5), max(new Random().nextInt(10)-5+getStrength(), 5), getSpiece(),
        new Random().nextInt(5)+20, new Random().nextInt(5)+20, x, y);
        Animals.add(ani);
        (new Thread(ani)).start();
    }
    public void die(){
        setIsAlive(false);
        if (getEnviromentByCoordinate(x, y) instanceof Crossroad){
            draw(x, y, "blank.png");
        }
        Animals.remove(this);
    }
    public String info(){
        String i = "Name: " + getName() + "\n";
        i += "Health: " + getHealth() + "\n";
        i += "Speed: " + getSpeed() + "\n";
        i += "Strenght: " + getStrength() + "\n";
        i += "Spiece: " + getSpiece() + "\n";
        i += "Water_level: " + water_level + "\n";
        i += "Food_level: " + food_level + "\n";
        i += "X coordinate: " + getX() + "\n";
        i += "Y coordinate: " + getY() + "\n";
        i += "Age: " + age + "\n";
        return i;
    }

    /**
     *brain of a prey, way it behaves
     */
    @Override
    public void run() {
        int goalX = -1;
        int goalY = -1;
        while(isIsAlive() == true){
        if ((goalX == -1 || goalY == -1) || (goalX == x && goalY == y)){
            if (water_level < 50){
                Enviroment goal = GUIController.getRandomEnviroment("Water_source");
                goalX = goal.getX();
                goalY= goal.getY();
            }
            else if (food_level < 50){
                Enviroment goal = GUIController.getRandomEnviroment("Food_source");
                goalX = goal.getX();
                goalY= goal.getY();
            }
            else if (!(GUIController.getEnviromentByCoordinate(x, y) instanceof Hideout)){
                Enviroment goal = GUIController.getRandomEnviroment("Hideout");
                goalX = goal.getX();
                goalY= goal.getY();
            }
        }
        if ((water_level < 100) && (GUIController.getEnviromentByCoordinate(getX(), getY()) instanceof Water_source)){
            try {
                drink((Water_source) GUIController.getEnviromentByCoordinate(getX(), getY()));
                Thread.sleep((long) (1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if ((food_level < 100) && (GUIController.getEnviromentByCoordinate(getX(), getY()) instanceof Food_source)){
            try {
                feed((Food_source) GUIController.getEnviromentByCoordinate(getX(), getY()));
                Thread.sleep((long) (1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if (goalX != getX() && goalY != getY()){
            if (new Random().nextInt(2) == 0){
                if (getY() > goalY){
                    move(getX(), getY() - 1);
                }
                else{
                    move(getX(), getY()+1);
                }
            }
            else{
                if (getX() > goalX){
                    move(getX()-1, getY());
                }
                else{
                    move(getX()+1, getY());
                }
            }
            try {
                Thread.sleep((long) (1000*getSpeed()));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            }
        else if ((goalX == getX()) && (goalY != getY())){
            if (getY() > goalY){
                move(getX(), getY()-1);
            }
            else{
                move(getX(), getY()+1);
            }
            try {
                Thread.sleep((long) (1000*getSpeed()));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else if ((goalY == getY()) && (goalX != getX())){
            if (getX() > goalX){
                move(getX()-1, getY());
            }
            else{
                move(getX()+1, getY());
            }
            try {
                Thread.sleep((long) (1000*getSpeed()));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if ((goalX == x && goalY == y) && (GUIController.getEnviromentByCoordinate(getX(), getY()) instanceof Hideout)){
            reproduce(x, y);
            water_level -= 30;
            food_level -= 30;
            try {
                Thread.sleep((long) (1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        if (water_level <= 0 || food_level <= 0 || getHealth() <= 0){
            die();
        }
        }
        die();
    }
}
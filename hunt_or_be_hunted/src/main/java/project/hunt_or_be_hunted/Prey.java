/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

import java.util.Random;

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
    synchronized
    public void drink(Water_source a) throws InterruptedException{
        if (a.getResource() < 100 - water_level){
            water_level += a.getResource();
            a.setResource(0);
        }
        else{
            a.setResource((int) (a.getResource() - water_level));
            water_level = 100;
        }
        System.out.println(info());
        Thread.sleep(1000);
    }
    synchronized
    public void feed(Food_source a) throws InterruptedException{
        if (a.getResource() < 100 - food_level){
            food_level += a.getResource();
            a.setResource(0);
        }
        else{
            a.setResource((int) (a.getResource() - food_level));
            food_level = 100;
        }
        System.out.println(info());
        Thread.sleep(1000);
    }
    synchronized
    public void move(int dest_x, int dest_y){
        try {
            if (GUIController.FreeSpace(dest_x, dest_y)){
                GUIController.animal_moves(dest_x, dest_y, x, y);
                setX(dest_x);
                setY(dest_y);
            }
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
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
        System.out.println(info());
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
            System.out.println("GOAL:" + goalX + " " + goalY);
        }
        if ((water_level < 100) && (GUIController.getEnviromentByCoordinate(getX(), getY()) instanceof Water_source)){
            try {
                drink((Water_source) GUIController.getEnviromentByCoordinate(getX(), getY()));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if ((food_level < 100) && (GUIController.getEnviromentByCoordinate(getX(), getY()) instanceof Food_source)){
            try {
                feed((Food_source) GUIController.getEnviromentByCoordinate(getX(), getY()));
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
            }
        else if (goalX == getX()){
            if (getY() > goalY){
                move(getX(), getY()-1);
            }
            else{
                move(getX(), getY()+1);
            }
        }
        else if (goalY == getY()){
            if (getX() > goalX){
                move(getX()-1, getY());
            }
            else{
                move(getX()+1, getY());
            }
        }
        }
    }
}
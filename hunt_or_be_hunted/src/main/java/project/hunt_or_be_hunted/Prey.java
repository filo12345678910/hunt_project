/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

/**
 *
 * @author filip
 */
public class Prey extends Animal implements Runnable {
    private float water_level;
    private float food_level;
    private float x;
    private float y;
    private float age;

    public Prey(String _name, float _health, float _speed, float _strength, String _spiece, float _water_level, float _food_level, float _x, float _y) {
        super(_name, _health, _speed, _strength, _spiece);
        water_level = _water_level;
        food_level = _food_level;
        x = _x;
        y = _y;
        age = 0;
    }
    
    public void eat(){
        
    }
    public void drink(){
        
    }
    public void findWater(){
        
    }
    public void findFood(){
        
    }
    public void walk(){
        
    }

    @Override
    public void run() {
        System.out.println("prey is alive");
    }
}
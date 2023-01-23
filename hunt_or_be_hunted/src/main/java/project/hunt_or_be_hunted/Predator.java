/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

/**
 *
 * @author filip
 */
public class Predator extends Animal implements Runnable {
    private boolean isHunting;
    private float x;
    private float y;

    public Predator(String _name, float _health, float _speed, float _strength, String _spiece, boolean _isHunting, float _x, float _y) {
        super(_name, _health, _speed, _strength, _spiece);
        isHunting = true;
        x = _x;
        y = _y;
    }
    
    public void walk(){
        
    }
    public void hunt(){
        
    }

    @Override
    public void run() {
        System.out.println("works predator");
    }
}
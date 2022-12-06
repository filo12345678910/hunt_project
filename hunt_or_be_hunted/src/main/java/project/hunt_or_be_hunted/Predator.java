/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

/**
 *
 * @author filip
 */
public class Predator extends Animal {
    private boolean isHunting;

    public Predator(String _name, float _health, float _speed, float _strength, String _spiece, boolean _isHunting) {
        super(_name, _health, _speed, _strength, _spiece);
        isHunting = _isHunting;
    }
    
    public void walk(){
        
    }
    public void hunt(){
        
    }
}
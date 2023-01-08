/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

/**
 *
 * @author filip
 */
public abstract class Animal {
    private String name;
    private float health;
    private float speed;
    private float strength;
    private String spiece;
    private float x;
    private float y;
    private boolean isAlive;
    
    public Animal(String _name, float _health, float _speed, float _strength, String _spiece, float _x, float _y){
        name = _name;
        health = _health;
        speed = _speed;
        strength = _strength;
        spiece = _spiece;
        x = _x;
        y = _y;
        isAlive = true;
    }
}

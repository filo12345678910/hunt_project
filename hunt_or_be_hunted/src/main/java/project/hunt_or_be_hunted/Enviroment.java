/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

/**
 *
 * @author filip
 */
public abstract class Enviroment {
    private int x;
    private int y;
    private int capacity;
    public Enviroment(int _x, int _y, int _capacity){
        x = _x;
        y = _y;
        capacity = _capacity;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

/**
 *
 * @author filip
 */
public class Water_source extends Enviroment {
    private int replenish_speed;

    public Water_source(int x, int y, int capacity, int _replenish_speed) {
        super(x, y, capacity);
        replenish_speed = _replenish_speed;
    }
}

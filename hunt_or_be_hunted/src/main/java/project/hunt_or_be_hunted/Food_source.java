/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

/**
 *
 * @author filip
 */
public class Food_source extends Enviroment {

    /**
     * @return the resource
     */
    public int getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(int resource) {
        this.resource = resource;
    }
    private int replenish_speed;
    private int resource;

    public Food_source(int x, int y, int capacity, int _replenish_speed) {
        super(x, y, capacity);
        replenish_speed = _replenish_speed;
        resource = 100;
    }
}
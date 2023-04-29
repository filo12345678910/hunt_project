/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    private String name;

    public Food_source(int x, int y, int capacity, int _replenish_speed) {
        super(x, y, capacity);
        replenish_speed = _replenish_speed;
        resource = 100;
        List<String> names = Arrays.asList("Gusteau's Restaurant", "The Snack Bar", "Pizza Planet", "The Krusty Krab");
        Random rand = new Random();
        name = names.get(rand.nextInt(names.size()));
    }
    public String Info(){
        String i = "name: " + name + "\n";
        i += "replenish speed: " + replenish_speed + "\n";
        i += "current capacity: " + resource + "\n";
        return i;
    }
}
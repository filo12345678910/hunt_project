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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the health
     */
    public float getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(float health) {
        this.health = health;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @return the strength
     */
    public float getStrength() {
        return strength;
    }

    /**
     * @return the spiece
     */
    public String getSpiece() {
        return spiece;
    }

    /**
     * @return the isAlive
     */
    public boolean isIsAlive() {
        return isAlive;
    }

    /**
     * @param isAlive the isAlive to set
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    private String name;
    private float health;
    private float speed;
    private float strength;
    private String spiece;
    private boolean isAlive;
    
    public Animal(String _name, float _health, float _speed, float _strength, String _spiece){
        name = _name;
        health = _health;
        speed = _speed;
        strength = _strength;
        spiece = _spiece;
        isAlive = true;
    }
}

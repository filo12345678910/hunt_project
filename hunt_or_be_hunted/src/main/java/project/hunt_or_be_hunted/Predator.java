/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

import static java.lang.StrictMath.abs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

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
    
    public void attack(Prey p){
        if (GUIController.getEnviromentByCoordinate(p.getX(), p.getY()) instanceof Hideout){
            return;
        }
        if (p.getHealth() <= getStrength()){
            p.setHealth(0);
            isHunting = false;
        }
        else{
            p.setHealth(p.getHealth() - getStrength());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public void move(Prey p){
        int temp = new Random().nextInt((int)getSpeed());
        float destX;
        float destY;
        if (p.getX()*50 < x){
            destX = x - temp;
        }
        else{
            destX = x + temp;
        }
        if (p.getY()*50 < y){
            destY = y - ((int)getSpeed() - temp);
        }
        else{
            destY = y + ((int)getSpeed() - temp);
        }
        GUIController.undraw_predator((int)x, (int)y);
        GUIController.draw_predator((int)destX, (int)destY);
        x = destX;
        y = destY;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        GUIController.draw_predator((int)x, (int)y);
        while(isIsAlive()){
            if(!(isHunting)){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                isHunting = true;
            }
            else if(isHunting){
                float d = 100000;
                float t;
                Animal tem = null;
                Collection<Animal> Animalss = GUIController.Animals;
                for (Animal animal : Animalss){
                    if (animal instanceof Prey){
                        t = abs((((Prey) animal).getX()*50) - x) + abs((((Prey) animal).getY()*50)-y);
                        if (t < d){
                            d = t;
                            tem = animal;
                        }
                    }
                }
                if (d < 100 && tem != null){
                    attack((Prey)tem);
                }
                else if(tem != null){
                    move((Prey)tem);
                }
            }
        }
    }
}
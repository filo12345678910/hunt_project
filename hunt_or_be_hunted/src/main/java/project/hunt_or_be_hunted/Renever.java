/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hunt_or_be_hunted;

import static project.hunt_or_be_hunted.GUIController.Animals;
import static project.hunt_or_be_hunted.GUIController.Enviroments;

/**
 *
 * @author filip
 */
public class Renever implements Runnable{

    @Override
    public void run() {
        while(true){
            for (Enviroment enviroment : Enviroments){
                if (enviroment instanceof Water_source){
                    ((Water_source) enviroment).setResource(((Water_source) enviroment).getResource() + Animals.size());
                }
                if (enviroment instanceof Food_source){
                    ((Food_source) enviroment).setResource(((Food_source) enviroment).getResource() + Animals.size());
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}

package com.jv_lp_01;

public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        this.health -= damage;
        if(this.health <= 0){
            System.out.println("Palyer knocked out");
            /* reduce number of lifes remainingn for the player */
        }
    }

    public int healthRemaining(){
        return this.health;
    }
}

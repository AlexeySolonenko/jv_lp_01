package com.jv_lp_01;

public class EnhancedPlayer {

    private String name;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int hitPoints, String weapon) {
        this.name = name;
        if(hitPoints > 0 && hitPoints < 100){
            this.hitPoints = hitPoints;
        }
        //this.hitPoints = hitPoints;
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        this.hitPoints -= damage;
        if(this.hitPoints <= 0){
            System.out.println("Palyer knocked out");
            /* reduce number of lifes remainingn for the player */
        }
    }

    public int getHealth() {
        return hitPoints;
    }
}

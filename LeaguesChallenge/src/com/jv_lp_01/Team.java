package com.jv_lp_01;

public abstract class Team implements Comparable<Team> {
    private String name;
    private int score;


    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @param team
     * @return int
     */
    @Override
    public int compareTo(Team team) {
        if (this.score > team.score) {
            return 1;
        }
        if (this.score < team.score) {
            return -1;
        } else {
            return 0;
        }
    }
}

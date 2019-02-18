package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        /* TODO to complete this example later, at this stage I got the grasp of LinkedList enough,*/
        /* main linked list related functionality is working OK - don't have time to continue more  */
        /* other examples with ArrayList and array are enough for practice/trainng with these topics */
            Player pl = new Player();
            pl.initAlbums();
            pl.initPlayList();
            pl.mainMenu();
            /* important to learn a structure */
            int[] intArr = {1, 2, 3, 4, 5};
            for(int i: intArr){
                System.out.println(i);
            }

    }
}

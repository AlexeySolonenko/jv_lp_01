package com.jv_lp_01;

/**
 * Created by dev on 20190203
 */
public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    /**
     *
     * @param model String
     * @return this Car
     */
    public Car setModel(String model){
        //this.model = model;
        String validModel = model.toLowerCase();
        if(validModel.equals("porsche") || validModel.equals("holden")){
            this.model = model;
        } else {
            this.model = "Unkown";
        }
        return this;
    }

    /**
     *
     * @return
     */
    public String getModel(){
        return this.model;
    }
}

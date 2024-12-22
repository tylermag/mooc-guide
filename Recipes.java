/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author choco
 */

import java.util.ArrayList;

public class Recipes {
    
    private String name;
    private int cookTime;
    private ArrayList<String> ingredients;
    
    public Recipes(String name){
        this.name = name;
        this.cookTime = 0;
        this.ingredients = new ArrayList<>();
    }
    
    public Recipes(String name, int cookTime){
        this.name = name;
        this.cookTime = cookTime;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getCookTime(){
        return this.cookTime;
    }
   
    public void addIngredient(String ingredient){
        this.ingredients.add(ingredient);
    }
    
    public ArrayList getIngredients(){
        return ingredients;
    }
    
    @Override
    public String toString(){
        return this.name + ", cooking time: " + this.cookTime;
    }
    
}

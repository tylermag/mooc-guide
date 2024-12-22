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

public class Book {

    private ArrayList<Recipes> recipes;

    public Book() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(String name, int cookTime) {
        this.recipes.add(new Recipes(name, cookTime));
    }

    public void addRecipe(String name) {
        this.recipes.add(new Recipes(name, 0));
    }

    public void addRecipe(Recipes recipe) {
        this.recipes.add(recipe);
    }

    public void findName(String search) {
        for (Recipes recipe : this.recipes) {
            String[] parts = recipe.getName().split(" ");
            for (int i = 0; i < parts.length; i++) {
                System.out.println("This method looped");
                if (parts[i].contains(search)) {
                    System.out.println(recipe);
                }
            }
        }
    }

    public void findCookTime(int search) {
        for (Recipes recipe : this.recipes) {
            if (recipe.getCookTime() <= search) {
                System.out.println(recipe);
            }
        }
    }

    public void printRecipes() {
        System.out.println("Recipes:");
        for (Recipes recipe : recipes) {
            System.out.println(recipe);
        }
    }

    public void findIngredient(String search) {
        for (Recipes recipe : this.recipes) {
            ArrayList<String> ingredients = recipe.getIngredients();
            for (String ingredient : ingredients) {
                if (ingredient.contains(search)) {
                    System.out.println(recipe);
                    break;
                }
            }
        }
    }
}


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book recipeBook = new Book();

        System.out.println("File to read:");

        String file = scanner.nextLine();
        
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        try (Scanner recipeTxt = new Scanner(Paths.get(file))) {

            // we read the file until all lines have been read
            while (recipeTxt.hasNextLine()) {
                // we read one line
                String name = recipeTxt.nextLine();
                // we print the line that we read
                int cookTime = Integer.valueOf(recipeTxt.nextLine());

                Recipes recipe = new Recipes(name, cookTime);
                recipeBook.addRecipe(recipe);

                while (recipeTxt.hasNextLine()) {

                    String ing = recipeTxt.nextLine();

                    if (ing.isEmpty()) {
                        break;
                    }

                    recipe.addIngredient(ing);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Enter command:");
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("list")) {
                recipeBook.printRecipes();
            } else if (command.equals("find name")) {
                System.out.println("Searched word:");
                String search = scanner.nextLine();
                recipeBook.findName(search);
            } else if (command.equals("find cooking time")) {
                System.out.println("Max cooking time:");
                int search = Integer.valueOf(scanner.nextLine());
                recipeBook.findCookTime(search);
            } else if (command.equals("find ingredient")) {
                System.out.println("Ingredient:");
                String search = scanner.nextLine();
                recipeBook.findIngredient(search);
            }
        }
    }
}


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recetario> recetario = new ArrayList<>();
        System.out.print("File to read: ");
        String file= scanner.nextLine();
        try (Scanner filer = new Scanner(Paths.get(file))) {
           Recetario receta=new Recetario();
 
            while (filer.hasNextLine()) {
                String linea=filer.nextLine();
                if(!linea.isEmpty()){
                    receta.add(linea);
                }
                else{
                    recetario.add(receta);
                    receta=new Recetario();
                }
            }
            recetario.add(receta);
            String command = "";
            System.out.print("\nCommands: "
                        + "\nlist - list the recipes"
                        + "\nstop - stops the program"
                        + "\nfind name - searches recipe by name"
                        + "\nfind cooking time - searches recipes by cooking name"
                        + "\nfind ingredient - searches recipes by ingredient\n");
            do {
                

                System.out.print("\nEnter command: ");
                command = scanner.nextLine();
                String found = "\n", find;
                switch (command) {
                    case "list":
                        for (Recetario recipe : recetario) {
                            System.out.println(recipe.toString());
                        }
                        break;
                    case "find name":
                        System.out.print("Searched word: ");
                        find = scanner.nextLine();

                        for (Recetario recipe : recetario) {
                            if (recipe.getName().contains(find)) {
                                found += recipe.toString() + "\n";
                            }
                        }
                        System.out.println("Recipes: " + found);
                        break;
                    case "find cooking time":
                        System.out.print("Max cooking time: ");
                        int time = Integer.valueOf(scanner.nextLine());

                        for (Recetario recipe : recetario) {
                            if (recipe.getTime() <= time) {
                                found +="\n"+ recipe.toString() ;
                            }
                        }
                        System.out.println("Recipes: " + found);
                        break;
                    case "find ingredient":
                        System.out.print("Ingredient:");
                        find = scanner.nextLine();

                        for (Recetario recipe : recetario) {
                            if (recipe.ingredients(find)) {
                                found += recipe.toString() + "\n";
                            }
                        }
                        System.out.println("Recipes: " + found);
                        break;
                }

            } while (!command.equals("stop"));
        }catch (Exception e) {
            
        }
        
        

    }

}

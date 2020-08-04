
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
            while (filer.hasNextLine()) {
                String linea="";
                Recetario receta=new Recetario();
                do{
                    linea=filer.nextLine();
                    receta.add(linea);
                }while(!linea.isEmpty());
                recetario.add(receta);
            }
        }catch (Exception e) {
            
        }
        System.out.print("\nCommands: "
                + "\nlist - list the recipes"
                + "\nstop - stops the program"
                + "\nfind name - searches recipe by name\n\n");
        String command="";
        do{
            System.out.print("Enter command:");
            command= scanner.nextLine();
            String found="\n", find;
            switch(command){
                case "list":
                    for(Recetario recipe:recetario ){
                        System.out.println(recipe.toString());
                    }
                    break;
                case "find name":
                    System.out.print("Searched word: ");
                    find = scanner.nextLine();
                    
                    for(Recetario recipe:recetario ){
                        if(recipe.getName().contains(find)){
                            found+=recipe.getName()+"\n";
                        }      
                    }
                    System.out.println("Recipes: "+found);
                    break;
                case "find cooking time":
                    System.out.print("Max cooking time: ");
                    int time =Integer.valueOf(scanner.nextLine());

                    for (Recetario recipe : recetario) {
                        if (recipe.getTime() <= time) {
                            found += recipe.toString() + "\n";
                        }
                    }
                    System.out.println("Recipes: "+found);
                    break;
                case "find ingredient":
                    System.out.print("Ingredient:");
                    find = scanner.nextLine();

                    for (Recetario recipe : recetario) {
                        if (recipe.ingredients(find)) {
                            found += recipe.toString() + "\n";
                        }
                    }
                    System.out.println("Recipes: "+found);
                    break;
            }
            
            
        }while(!command.equals("stop"));
        

    }

}

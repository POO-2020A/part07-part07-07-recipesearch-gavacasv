
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> recipes = new ArrayList<>();
        recipes.add("");
        System.out.print("File to read: ");
        String file= scanner.nextLine();
        String line= "";
        try (Scanner filer = new Scanner(Paths.get(file))) {
           
            while (filer.hasNextLine()) {
                recipes.add(filer.nextLine());
            }
            
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
                String found , find;
                switch (command) {
                    case "list":
                        int i=0;
                        do{
                            if(!recipes.get(i).isEmpty()){
                                i++;
                            }
                            else{
                                System.out.println(recipes.get(++i)+", cooking time: "+recipes.get(++i));
                            }
                        }while(i<recipes.size());
                        break;
                    case "find name":
                        System.out.print("Searched word: ");
                        find = scanner.nextLine();
                        found="\n";
                        String auxiliar="";
                        i=0;
                        String[] words;

                        do{
                            if (recipes.get(i).isEmpty()) {
                                int j=i+1;
                                auxiliar = recipes.get(++i) + ", cooking time: " + recipes.get(++i);
                                words = recipes.get(j).split(" "); 
                                for(String word:words){
                                    if (word.contains(find)) {
                                        
                                       found +=  auxiliar+"\n";
                                    }
                                }
                            }

                            else{
                                i++;
                                
                            }
                        }while(i<recipes.size() );
                        System.out.println("Recipes: " + found);
       
                        break;
                    case "find cooking time":
                        found="\n";
                        System.out.print("Max cooking time: ");
                        
                        i=0;
                        find = scanner.nextLine();
                        int time=Integer.valueOf(find);
                        int timer;
                    
                        do{
                            if (!recipes.get(i).isEmpty()) {
                                i++;
                            } else {
                                auxiliar = recipes.get(++i)+", cooking time: "+recipes.get(++i);
                                timer=Integer.valueOf(recipes.get(i));
                                if (timer <= time) {
                                    found += "\n" + auxiliar;
                                }
                            }
                        }while (i < recipes.size() );
                                          
                        System.out.println("Recipes: " + found);
                        break;
                    case "find ingredient":
                        found="";
                        System.out.print("Ingredient:");
                        find = scanner.nextLine();
                        auxiliar = "";
                        i = 0;
                        

                        do {
                            if (recipes.get(i).isEmpty()) {
                                
                                auxiliar = recipes.get(++i)+", cooking time: "+recipes.get(++i);
                            } else {
                                
                                words = recipes.get(i).split(" ");
                                for (String word : words) {
                                    if (word.equals(find)) {
                                      found += "\n" + auxiliar ;
                                    }
                                }
                                i++;
                            }
                        }while (i < recipes.size() );

                        System.out.println("Recipes: " + found);
                        break;
                }

            } while (!command.equals("stop"));
        }catch (Exception e) {
            
        }
    }
    
    

}

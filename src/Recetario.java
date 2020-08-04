import java.util.ArrayList;
public class Recetario {
    private ArrayList<String> receta ;

    public Recetario() {
        receta = new ArrayList<>();
    }
    public void add(String linea){
        receta.add(linea);
    }
    public String toString(){
        
        return receta.get(0)+", cooking time: "+receta.get(1);
    }
    public String getName(){
        
        return receta.get(0);
    }
    public int getTime(){
        
        return Integer.valueOf(receta.get(1));
    }
    public boolean ingredients( String ingredient){
        boolean here=false;
        for(int i=2; i<this.receta.size(); i++){
            if(this.receta.get(i).contains(ingredient)){
                here= true;
                break;
            }
            
        }
        return here;
    }
}
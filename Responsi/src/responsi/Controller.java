/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;


/**
 *
 * @author mac
 */
public class Controller extends Film{
    Model Mod;
    private String title;
    private int score,plot, character,acting;
    
    public void setModel (Model Mdl){
        this.Mod = Mdl;
    }
   
    public void inputData(Film flm){
        this.title = flm.getTitle();
        this.character = Integer.valueOf(flm.getCharacter());
        this.plot = Integer.valueOf(flm.getPlot());
        this.acting = Integer.valueOf(flm.getActing());
        this.score = (character + plot + acting)/3;
        System.out.println(score);
        
        Mod.setTitle(this.title);
        Mod.setPlot(this.plot);
        Mod.setCharacter(this.character);
        Mod.setActing(this.acting);
        Mod.setScore(this.score);
        Mod.insertData();
    }
    
    public void viewTable(Film movie){
        Mod.table(movie);
    }
    
    public void deleteTable(){
        Mod.deleteTable();
    }

    void hapusLayar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

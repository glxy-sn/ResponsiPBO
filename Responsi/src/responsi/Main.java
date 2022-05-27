/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package responsi;

/**
 *
 * @author mac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Film flm = new Film();
        flm.setVisible(true);
        flm.pack();
        flm.requestFocusInWindow();
        flm.setLocationRelativeTo(null);
    }
    
}

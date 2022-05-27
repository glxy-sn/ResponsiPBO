/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package responsi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mac
 */
public class Model {
    public Connection conn;
    public Statement statement;
    private String title;
    private int score,plot, character,acting;
    
    public void setScore(int score){
        this.score = score;
    }
    public void setPlot(int plot){
        this.plot = plot;
    }
    public void setCharacter(int character){
        this.character = character;
    }
    public void setActing(int acting){
        this.acting = acting;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/my_movie?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.println("Connect Success");
        }catch(Exception ex){
            System.out.println("Connect Failed " + ex.getMessage());
        }
    }
    public void insertData(){
        try{
            String query = "INSERT INTO `movie`(`title`, `plot`, `character`, `acting`, `score`) VALUES ('"+this.title+"','"+this.plot+"','"+this.character+"','"+this.acting+"','"+this.score+"')";
            this.Connector();
                statement = conn.createStatement();
                statement.execute(query);
                JOptionPane.showMessageDialog(null,"Insert Successful");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex, "Cannot Open", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void table(Film movie){
        try{
            this.Connector();
            statement = conn.createStatement();
            String query = "SELECT * FROM `movie`";
            ResultSet resultSet = statement.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) movie.table.getModel();
            model.setRowCount(0);
            while (resultSet.next()){
                model.addRow(new String[]{resultSet.getString(1)});
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Cannot Open", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void deleteTable(){
        try{
            this.Connector();
            statement = conn.createStatement();
            String query = "DELETE FROM `movie`";
            statement.execute(query);
            JOptionPane.showMessageDialog(null,"Data Successfully Deleted");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.WARNING_MESSAGE);
        }
    }
}

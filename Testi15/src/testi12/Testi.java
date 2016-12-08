
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilker
 */
public class Testi {
    private static final String URL = "jdbc:mysql://mysql.labranet.jamk.fi/H3278_2";
    private static final String USER = "H3278";
    private static final String PASS = "55wITLCoHE8VuTKTPAxXkQI5ZvxC0Il2";
    private static Connection Yhteys = null;
    public static void main(String[] args){ 
        try{
            Yhteys = DriverManager.getConnection(URL,USER,PASS);
            
             ResultSet tulos = null;
              Statement kmt = Yhteys.createStatement();
             // tulos = kmt.executeQuery("select * from Asiakas");
              //poistaKirja("Yritys Oy");
              lisaaKirja("123123124");
            
              while(tulos.next())
        {
        
           // System.out.println("AsiakasNimi="+tulos.getString("AsiakasNimi"));
           // System.out.println("VakuutusNimi="+tulos.getString("VakuutusNimi"));
            //System.out.println("Osoite="+tulos.getString("Osoite")); 
            System.out.println();
                                      
        }
              
        }catch(SQLException ex){
        ex.printStackTrace();
        System.exit(1);
        }
        
    }
        public static int lisaaKirja(String kirjanNimi) {
        int i=0;
        try { 
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("insert into kirja(kirjanNimi) values ('"+kirjanNimi+"')");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
     
    }
            public static int poistaKirja(String AsiakasNimi){
        int i=0;
        try {           
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("DELETE FROM kirja WHERE kirjannimi='"+AsiakasNimi+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
     
    }
}
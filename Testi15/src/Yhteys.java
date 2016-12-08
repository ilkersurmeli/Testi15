
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class Yhteys {
    private static final String URL = "jdbc:mysql://mysql.labranet.jamk.fi/H3278_2";
    private static final String USER = "H3278";
    private static final String PASS = "55wITLCoHE8VuTKTPAxXkQI5ZvxC0Il2";
    private static Connection Yhteys = null;
    Yhteys(){ 
        try{
            System.out.println("LMMMMM kirja");
            Yhteys = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Yhteys kirja");
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        System.exit(1);
        }
    }
     
    public int lisaaKirja(String kirjanNimi,String kirjailijanNimi,String vuosi){
        int i=0;
        System.out.println("Lisää kirja");
        try {           
            Statement kmt = Yhteys.createStatement();
            
            i = kmt.executeUpdate("insert into kirja(kirjanNimi,kirjailijanNimi,vuosi) values ('"+kirjanNimi+"','"+kirjailijanNimi+"','"+vuosi+"')");
            
           // i = kmt.executeUpdate("insert into Vakuutukset(VakuutusId) values ('"+VakuutusId+"')");
           

            System.out.println("Lisätty kirja");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
     
    }
    public int poistaKirja(String kirjanNimi){
        int i=0;
        try {           
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("DELETE FROM kirja WHERE kirjanNimi='"+kirjanNimi+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
     
    }
        public List<Luokka> listaaVapaaKirja(){
        List<Luokka> tietoja = new ArrayList<Luokka>();
        ResultSet tullut = null;
        try{
        Statement kmt = Yhteys.createStatement();
        tullut = kmt.executeQuery("select * from kirja where alue is null");
        while(tullut.next())
        {
        tietoja.add(new Luokka(tullut.getString("kirjanNimi"),tullut.getString("kirjailijanNimi"),tullut.getString("vuosi")));
        
        }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            tullut.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return tietoja;
    
    }
        public int varaaKirja(String kirja,String jasenNo){
        int i=0;
        try {           
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("update kirja set alue='"+jasenNo+"' where kirjanNimi='"+kirja+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;    
    } 
        public String[] etsiJasen(String jasenNo,String sotu)
    {
        String [] löytynyt = new String[2];
        ResultSet tulos = null;
        try {
            Statement kmt = Yhteys.createStatement();
            tulos = kmt.executeQuery("select etunimi,sukuNimi from jasen where jasenNo='"+jasenNo+"' AND sotu='"+sotu+"'");
            while(tulos.next())
            {
            löytynyt[0] = tulos.getString("etunimi");
            löytynyt[1] = tulos.getString("sukunimi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return löytynyt;
    }
        public String [] jasenin(String jasenNo){    

        String [] sarja = new String[10];
        ResultSet tulos = null;
        try{
        Statement kmt = Yhteys.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        tulos = kmt.executeQuery("select kirjanNimi from kirja where alue='"+jasenNo+"'");

        int i=0;
        while(tulos.next())
        {
        sarja[i]=tulos.getString("kirjanNimi"); 
        i++;
        }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            tulos.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return sarja;
}
            public int uusiJasen(String jasenNo,String so,String etunimi,String sukunimi){
 
        int i=0;
        try {           
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("insert into jasen(jasenNo,sotu,etunimi,sukunimi) values ('"+jasenNo+"','"+so+"','"+etunimi+"','"+sukunimi+"')");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
     
    }
                public int poistaJasen(String so){
        int i=0;
        try {           
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("DELETE FROM jasen WHERE sotu='"+so+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
     
    }
            public List<Luokka> listaJasen(){
        List<Luokka> data = new ArrayList<Luokka>();
        ResultSet tulos = null;
        try{
        Statement kmt = Yhteys.createStatement();
        tulos = kmt.executeQuery("select * from jasen");
        while(tulos.next())
        {
        data.add(new Luokka(tulos.getString("jasenNo"),tulos.getString("sotu"),tulos.getString("etunimi"),tulos.getString("sukunimi")));
        
        }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            tulos.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return data;
        }
            public String[] etsiJasen2(String jasenNo)
    {
        String [] löytynyt = new String[3];
        ResultSet tulos = null;
        try {
            Statement kmt = Yhteys.createStatement();
            tulos = kmt.executeQuery("select etunimi,sukunimi,sotu from jasen where jasenNo='"+jasenNo+"'");
            while(tulos.next())
            {
            löytynyt[0] = tulos.getString("etunimi");
            löytynyt[1] = tulos.getString("sukunimi");
            löytynyt[2] = tulos.getString("sotu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return löytynyt;
    }
            public int palauta(String kirja,String jasenNo){
        int i=0;
        try {           
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("update kirja set alue=null where kirjanNimi='"+kirja+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;    
    }
           public int muokkaJasen(String so,String nimi,String suku){
        int i=0;
        try {           
            Statement kmt = Yhteys.createStatement();
            i = kmt.executeUpdate("update jasen set sotu='"+so+"',etunimi='"+nimi+"',sukunimi='"+suku+"' where sotu='"+so+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;    
    } 
           
  public List<Luokka> etsi(String mika,String etsiva){    
List<Luokka> data = new ArrayList<Luokka>();
        ResultSet tulos = null;
        try{
        Statement kmt = Yhteys.createStatement();
        tulos = kmt.executeQuery("select * from kirja where "+mika+"='"+etsiva+"'");
        while(tulos.next())
        {
        data.add(new Luokka(tulos.getString("kirjanNimi"),tulos.getString("KirjailijanNimi"),tulos.getString("vuosi")));
        
        }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            tulos.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return data;
}
      public List<Luokka> listaKirja(){
        List<Luokka> data = new ArrayList<Luokka>();
        ResultSet tulos = null;
        try{
        Statement kmt = Yhteys.createStatement();
        tulos = kmt.executeQuery("select * from kirja");
        while(tulos.next())
        {
        data.add(new Luokka(tulos.getString("kirjanNimi"),tulos.getString("kirjailijanNimi"),tulos.getString("vuosi")));
        
        }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            tulos.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return data;
    
    }
      public List<Luokka> etsi2(String mita,String etsitty){    
        List<Luokka> data = new ArrayList<Luokka>();
        ResultSet tulos = null;
        try{
        Statement kmt = Yhteys.createStatement();
        tulos = kmt.executeQuery("select * from kirja where "+mita+" LIKE '%"+etsitty+"%'");
        while(tulos.next())
        {
        data.add(new Luokka(tulos.getString("kirjanNimi"),tulos.getString("kirjailijanNimi"),tulos.getString("vuosi")));
        
        }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            tulos.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return data;
}
     
   
 
 
 






    }

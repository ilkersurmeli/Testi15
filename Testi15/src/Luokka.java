/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilker
 */
public class Luokka {
    
    private String kirjanNimi;
    private String kirjailija;
    private String etunimi;
    private String sukunimi;
    private String sotu;
    private String jasenNo; 
    private String vuosi;
    
    Luokka(){
        asetaKirjanNimi("");
        asetaKirjailija("");
        asetaNimi("");
        asetaSukunimi("");
        asetaSotu("");
        asetaJasenNo("");        
    }
    Luokka(String j,String t,String n,String s){
        asetaNimi(n);
        asetaSukunimi(s);
        asetaSotu(t);
        asetaJasenNo(j);        
    }
    Luokka(String ki,String ya,String vu){
        asetaKirjanNimi(ki);
        asetaKirjailija(ya);
        asetaVuosi(vu);        
    }
    
    public void asetaKirjanNimi(String kirja){
        kirjanNimi = kirja;
    }      
    
    public String tuoKirjanNimi(){
    return kirjanNimi;
    }
    public void asetaVuosi(String year){
        vuosi = year;
    }      
    
    public String tuoVuosi(){
    return vuosi;
    }
    
    public void asetaKirjailija(String writer){
        kirjailija = writer;
    }      
    
    public String tuoKirjailija(){
    return kirjailija;
    }
    
    public void asetaNimi(String name){
        etunimi = name;
    }   
    
    public String tuoNimi(){
    return etunimi;
    }
    
    public void asetaSukunimi(String surname){
        sukunimi = surname;
    }
    
    public String tuoSukunimi(){
    return sukunimi;
    }
    
    public void asetaSotu(String hetu){
        sotu = hetu;
    }   
    
    public String tuoSotu(){
    return sotu;
    }
    
    public void asetaJasenNo(String jasenNum){
        jasenNo = jasenNum;
    }   
    
    public String tuoJasenNo(){
    return jasenNo;
    }
       
    
}



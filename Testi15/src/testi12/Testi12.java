/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilker
 */
public class Testi12 {
    
    private String AsiakasNimi;
    private String AsiakasId;
    private String Osoite;
    private String sukunimi;
    private String sotu;
    private String jasenNo; 
    private String vuosi;
    
    Testi12(){
        asetaKirjanNimi("");
        asetaKirjailija("");
        asetaNimi("");
        asetaSukunimi("");
        asetaSotu("");
        asetaJasenNo("");        
    }
    Testi12(String j,String t,String n,String s){
        asetaNimi(n);
        asetaSukunimi(s);
        asetaSotu(t);
        asetaJasenNo(j);        
    }
    Testi12(String ki,String ya,String vu){
        asetaKirjanNimi(ki);
        asetaKirjailija(ya);
        asetaVuosi(vu);        
    }
    
    public void asetaKirjanNimi(String kirja){
        AsiakasNimi = kirja;
    }      
    
    public String tuokirjanNimi(){
    return AsiakasNimi;
    }
    public void asetaVuosi(String year){
        vuosi = year;
    }      
    
    public String tuoVuosi(){
    return vuosi;
    }
    
    public void asetaKirjailija(String writer){
        AsiakasId = writer;
    }      
    
    public String tuoKirjailija(){
    return AsiakasId;
    }
    
    public void asetaNimi(String name){
        Osoite = name;
    }   
    
    public String tuoNimi(){
    return Osoite;
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



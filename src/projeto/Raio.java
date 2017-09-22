/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ice
 */
public class Raio {
    
    private double latitude;
    private double longitude;
    private Date data;
    private   String descrição;

    public Raio() {
    }

    public Raio(double latitude, double longitude, Date data, String descrição) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.descrição = descrição;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

   

 


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


 




    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    @Override
    public String toString() {
        return this.descrição; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
   
    
    
    
    
}

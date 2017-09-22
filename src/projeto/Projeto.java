/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ice
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) throws ParseException {
        
        JanelaRaio janela = new JanelaRaio(getSampleData());
        janela.setSize(500, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
     
      }
      private static List<Raio> getSampleData() throws ParseException {
       DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Raio r1;
          r1 = new Raio(1,1,(Date)formatter.parse("11/11/34"),"Raio Grande 1");
          
        List<Raio> raio = new ArrayList<>();
        raio.add(r1);

        return raio;
    }
    
   
    
}

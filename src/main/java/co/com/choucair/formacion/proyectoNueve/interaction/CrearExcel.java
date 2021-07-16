package co.com.choucair.formacion.proyectoNueve.interaction;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearExcel implements Interaction {
    private static final Logger LOGGER = Logger.getLogger(CrearExcel.class.getName());
    String listabancos[] = new String[20];
    String listalinks[] = new String[20];
    int tamano;


    public static void CrearExcel (String listabancos[],String listalinks[], int tamano){

        Workbook book = new XSSFWorkbook(); //Crear un archivo en excel
        Sheet sheet = book.createSheet("Paginas amarillas");

        for(int i=0; i < tamano; i++) {
            Row row = sheet.createRow(i); // crear #filas
            row.createCell(0).setCellValue(listabancos[i]); //crea n celdas y escribe *
            row.createCell(4).setCellValue(listalinks[i]); //crea n celdas y escribe *
        }

        try{FileOutputStream fileout = new FileOutputStream("retoNueve.xlsx");
            book.write(fileout);
            fileout.close();} catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE,null, e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       CrearExcel(listabancos,listalinks,tamano);
        
    }



}

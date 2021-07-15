package co.com.choucair.formacion.proyectoNueve.interaction;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Excel implements Interaction {
    private static final Logger LOGGER = Logger.getLogger(Excel.class.getName());

    public static void crearExcel(){
        String data = new String();
        Workbook book = new XSSFWorkbook(); //Crear un archivo en excel
        Sheet sheet = book.createSheet("Paginas amarillas");
        Row row = sheet.createRow(0);
        for(int i=0; i<15 ;i++) {
            row.createCell(i).setCellValue(data);
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
    public <T extends Actor> void performAs(T actor) {}




}

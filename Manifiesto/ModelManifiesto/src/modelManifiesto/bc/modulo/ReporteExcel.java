package modelManifiesto.bc.modulo;

import java.io.FileOutputStream;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import modelManifiesto.bc.ManifiestoModuloImpl;

import oracle.jbo.JboException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReporteExcel {

    public static void ReporteManifiesto(ManifiestoModuloImpl manifiestoModulo) {

        Workbook writeWorkbook = new HSSFWorkbook();
        Sheet desSheet = writeWorkbook.createSheet("new sheet");

        ResultSet resultSet = manifiestoModulo.getBaseDML().ejecutaConsulta("select * from v_manifiesto vm");
        if (manifiestoModulo.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            org.apache.poi.ss.usermodel.Row desRow1 = desSheet.createRow(0);
            for (int col = 0; col < columnsNumber; col++) {
                org.apache.poi.ss.usermodel.Cell newpath = desRow1.createCell(col);
                newpath.setCellValue(rsmd.getColumnLabel(col + 1));
            }
            while (resultSet.next()) {
                org.apache.poi.ss.usermodel.Row desRow = desSheet.createRow(resultSet.getRow());
                for (int col = 0; col < columnsNumber; col++) {
                    org.apache.poi.ss.usermodel.Cell newpath = desRow.createCell(col);
                    newpath.setCellValue(resultSet.getString(col + 1));
                }
                FileOutputStream fileOut = new FileOutputStream("/tmp/test.xls");
                writeWorkbook.write(fileOut);
                fileOut.close();
            }
        } catch (Exception e) {

        }

    }


}

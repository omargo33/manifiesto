  package WEB-INF.classes.modelManifiesto.bc.modulo;
  
  import java.io.FileOutputStream;
  import java.sql.ResultSet;
  import java.sql.ResultSetMetaData;
  import modelManifiesto.bc.ManifiestoModuloImpl;
  import oracle.jbo.JboException;
  import org.apache.poi.hssf.usermodel.HSSFWorkbook;
  import org.apache.poi.ss.usermodel.Cell;
  import org.apache.poi.ss.usermodel.Row;
  import org.apache.poi.ss.usermodel.Sheet;
  
  
  
  
  
  public class ReporteExcel
  {
    public static void ReporteManifiesto(ManifiestoModuloImpl manifiestoModulo) {
      HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
      Sheet desSheet = hSSFWorkbook.createSheet("new sheet");
      
      ResultSet resultSet = manifiestoModulo.getBaseDML().ejecutaConsulta("select * from v_manifiesto vm", new Object[0]);
      if (manifiestoModulo.getBaseDML().getMensaje() != null) {
        throw new JboException("no consulta SQL");
      }
      
      try {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        Row desRow1 = desSheet.createRow(0);
        for (int col = 0; col < columnsNumber; col++) {
          Cell newpath = desRow1.createCell(col);
          newpath.setCellValue(rsmd.getColumnLabel(col + 1));
        } 
        while (resultSet.next()) {
          Row desRow = desSheet.createRow(resultSet.getRow());
          for (int col = 0; col < columnsNumber; col++) {
            Cell newpath = desRow.createCell(col);
            newpath.setCellValue(resultSet.getString(col + 1));
          } 
          FileOutputStream fileOut = new FileOutputStream("/tmp/test.xls");
          hSSFWorkbook.write(fileOut);
          fileOut.close();
        } 
      } catch (Exception exception) {}
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/modulo/ReporteExcel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.UserProfile;
import ai.aecode.testweb.repositories.IUserProfileRepository;
import ai.aecode.testweb.services.IExcelExportService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExcelExportServiceImplement implements IExcelExportService {
    @Autowired
    private IUserProfileRepository upR;
    private static final String TEMP_DIR_PATH = "/tmp";
    private static final String BACKUP_FILE_NAME = "userprofiles_backup.xlsx";

    @Override
    public void exportUserProfilesToExcel() throws IOException {
            File tempDir = new File(TEMP_DIR_PATH);
            if (!tempDir.exists()) {
                tempDir.mkdirs();
            }

            File file = new File(tempDir, BACKUP_FILE_NAME);
            Workbook workbook;
            Sheet sheet;
            boolean fileExists = file.exists();

            // Crear o leer el archivo Excel
            if (fileExists) {
                FileInputStream fileIn = new FileInputStream(file);
                workbook = new XSSFWorkbook(fileIn);
                sheet = workbook.getSheet("UserProfiles");
                fileIn.close();
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("UserProfiles");
                // Crear fila de encabezado si el archivo es nuevo
                Row headerRow = sheet.createRow(0);
                String[] columns = {"ID", "Name", "Email", "Birthday", "Gender", "Zodiac Sign", "Element"};
                for (int i = 0; i < columns.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(columns[i]);
                }
            }

            // Obtener todos los perfiles de usuario de la base de datos
            List<UserProfile> userProfiles = upR.findAll();

            // Mapa para verificación de IDs existentes en el Excel
            int lastRowNum = sheet.getLastRowNum();
            Set<Integer> existingIds = new HashSet<>();
            for (int i = 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell idCell = row.getCell(0);
                    if (idCell != null) {
                        existingIds.add((int) idCell.getNumericCellValue());
                    }
                }
            }

            // Crear o actualizar filas de datos
            for (UserProfile userProfile : userProfiles) {
                int userId = userProfile.getId_user();
                Row row = null;
                if (existingIds.contains(userId)) {
                    // Actualizar la fila existente
                    for (int i = 1; i <= lastRowNum; i++) {
                        Row tempRow = sheet.getRow(i);
                        if (tempRow != null) {
                            Cell idCell = tempRow.getCell(0);
                            if (idCell != null && (int) idCell.getNumericCellValue() == userId) {
                                row = tempRow;
                                break;
                            }
                        }
                    }
                }
                if (row == null) {
                    // Crear nueva fila
                    row = sheet.createRow(++lastRowNum);
                }

                // Agregar datos a la fila
                row.createCell(0).setCellValue(userProfile.getId_user());
                row.createCell(1).setCellValue(userProfile.getUser_name());
                row.createCell(2).setCellValue(userProfile.getUser_email());
                row.createCell(3).setCellValue(userProfile.getUser_birthday().toString());
                row.createCell(4).setCellValue(userProfile.getUser_gender());
                row.createCell(5).setCellValue(userProfile.getZodiacsign().getSign_name());
                row.createCell(6).setCellValue(userProfile.getElement().getElement_name());
            }

            // Ajustar el tamaño de las columnas automáticamente
            for (int i = 0; i < 7; i++) {
                sheet.autoSizeColumn(i);
            }

            // Guardar el libro de trabajo en un archivo
            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                workbook.write(fileOut);
            }

            workbook.close();
        }

}

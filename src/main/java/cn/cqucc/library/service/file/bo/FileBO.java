package cn.cqucc.library.service.file.bo;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.admin.directory.AdminDirectory;
import cn.cqucc.library.model.school.School;
import cn.cqucc.library.service.admin.dao.ICKAdminDAO;
import cn.cqucc.library.service.file.api.FileAPI;
import cn.cqucc.library.service.school.dao.ISchoolDAO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;

/**
 * @author JianfeiChen
 * @date 2020/6/5 10:23
 * @Description cn.cqucc.library.service.file.bo
 */
@Service
public class FileBO implements FileAPI {

    @Autowired
    ICKAdminDAO adminDAO;
    @Autowired
    ISchoolDAO schoolDAO;

    @Override
    public String importFile(MultipartFile file, String filePath) {
        String msg = "";
        StringJoiner buffer = new StringJoiner("\n");
        try {
            if (filePath != null) {
                InputStream inputStream = file.getInputStream();
                Workbook book = null;
                if (isExcel2003(filePath)) {
                    book = new HSSFWorkbook(inputStream);
                }
                if (isExcel2007(filePath)) {
                    book = new XSSFWorkbook(inputStream);
                }
                Sheet sheet = book.getSheetAt(0);
                int allRowNum = sheet.getLastRowNum();
                if (allRowNum == 0) {
                    buffer.add("导入文件数据为空");
                }
                Admin admin;
                School school;
                List<Admin> admins = new ArrayList<>();
                List<School> schools = new ArrayList<>();
                for (int i = 1; i <= allRowNum; i++) {
                    Row row = sheet.getRow(i); //获取第i行
                    if (row != null) {
                        // 获取第1个单元格的数据
                        Cell schoolName = row.getCell(0);
                        Cell schoolCode = row.getCell(1);
                        Cell schoolLocation = row.getCell(2);
                        Cell schoolAdmin = row.getCell(3);
                        Cell adminAccount = row.getCell(4);
                        Cell adminPassword = row.getCell(5);
                        if (cellValid(schoolName) || cellValid(schoolCode) || cellValid(schoolLocation) || cellValid(schoolAdmin) || cellValid(adminAccount) || cellValid(adminPassword)) {
                            buffer.add("第" + i + "行的数据有误或存在空值");
                        } else {
                            String account = adminAccount.getStringCellValue();
                            String password = adminPassword.getStringCellValue();
                            String name = schoolName.getStringCellValue();
                            String code = schoolCode.getStringCellValue();
                            String location = schoolLocation.getStringCellValue();
                            String adminName = schoolAdmin.getStringCellValue();
                            if (isNorm(account) || isNorm(password)) {
                                buffer.add("第" + i + "行的账户或密码不规范");
                                continue;
                            }
                            school = new School(code, name, location, account, true, new Date());
                            admin = new Admin(UUID.randomUUID().toString().replaceAll("-", ""),
                                    adminName, account, password, true,
                                    new Date(), name, code, location,
                                    AdminDirectory.AdminLevel.SCHOOL_SUPER_ADMIN);
//                            schools.add(school);
//                            admins.add(admin);
                        }
                    }
                }
                schoolDAO.addSchools(schools);
                adminDAO.addAdmins(admins);
                if ("".equals(buffer.toString())) {
                    msg = "导入成功";
                } else {
                    msg = buffer.toString();
                }

            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 判断文件类型是不是2003版本
     *
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 判断文件类型是不是2007版本
     *
     * @param filePath
     * @return
     */
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 判断数据是否有效
     *
     * @param cell
     * @return
     */
    public static boolean cellValid(Cell cell) {
        return cell == null || "".equals(cell.getStringCellValue());
    }

    /**
     * 判断管理员账户、密码是否规范
     *
     * @param data
     * @return
     */
    public static boolean isNorm(String data) {
        String regex = "^[a-z0-9A-Z]+$";
        return !(data.matches(regex)) && data.length() > 6 && data.length() < 16;
    }
}

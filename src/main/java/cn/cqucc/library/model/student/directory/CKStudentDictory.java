package cn.cqucc.library.model.student.directory;

import cn.cqucc.library.utils.annotation.description.Description;

/**
 * @author JianfeiChen
 * @date 2020/4/26 11:12
 * @Description cn.cqucc.library.model.student.directory
 */

@Description(description = "学生数据字典")
public class CKStudentDictory {

    public static class UserType {

        @Description(description = "学生")
        public static int student = 0;

        @Description(description = "教职工")
        public static int staff = 1;

    }
}

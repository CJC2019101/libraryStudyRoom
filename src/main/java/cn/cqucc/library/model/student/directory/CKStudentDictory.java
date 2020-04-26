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

        @Description(description = "全部")
        private static int all = 0;

        @Description(description = "学生")
        private static int student = 1;

        @Description(description = "管理员")
        private static int manager = 2;


    }
}

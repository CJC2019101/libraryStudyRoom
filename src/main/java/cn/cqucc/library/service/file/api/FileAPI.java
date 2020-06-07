package cn.cqucc.library.service.file.api;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author JianfeiChen
 * @date 2020/6/5 10:22
 * @Description cn.cqucc.library.service.file.bo
 */
public interface FileAPI {
    /**
     * 文件导入院校信息
     *
     * @param file
     * @param filePath
     * @return
     */
    String importFile(MultipartFile file, String filePath);
}

package org.dao.doraemon.excel.storage;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * 本地Excel存储管理
 *
 * @author sucf
 * @since 1.0
 */
@Component
public class LocalExcelStorageProcessor implements ExcelStorageProcessor {

    private final String storageLocalPath;

    public LocalExcelStorageProcessor(String storageLocalPath) {
        this.storageLocalPath = storageLocalPath;
    }

    @Override
    public String submit(String fileName, Workbook workbook) {
        String fullPath = storageLocalPath + File.separator + fileName;

        File file = new File(fullPath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                throw new RuntimeException("无法创建目录：" + parentDir.getAbsolutePath());
            }
        }

        // 创建文件并写入数据
        try (FileOutputStream fileOutputStream = new FileOutputStream(fullPath)) {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 返回文件的下载链接
        return "http://localhost:8080/excel/download/" + fileName;
    }


    @Override
    public void delete(String path) {
    }

    @Override
    public InputStream download(String path) {
        File file = new File(storageLocalPath + path);
        if (file.exists()) {
            try {
                return new FileInputStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}

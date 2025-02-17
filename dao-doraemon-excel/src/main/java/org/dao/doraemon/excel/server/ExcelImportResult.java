package org.dao.doraemon.excel.server;

import lombok.Data;

/**
 * Excel 文件导入返回结构
 *
 * @author sucf
 * @since 1.0
 */
@Data
public class ExcelImportResult {
    /**
     * 处理失败错误数量
     */
    private Integer failCount;

    /**
     * 处理成功数量
     */
    private Integer successCount;

    /**
     * 跳过总数量
     */
    private Integer skipCount;

    /**
     * 导入内容总数(去掉跳过数量+从表头后开始计算)
     */
    private Integer totalCount;

    /**
     * 错误文件下载地址
     */
    private String failDownloadAddress;
}

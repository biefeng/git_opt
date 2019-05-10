package com.biefeng.excel;

import com.biefeng.excel.template.impl.TemplateExpression;
import com.biefeng.excel.template.impl.ValueType;
import com.comm.util.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/*
 *@Author BieFeNg
 *@Date 2019/5/10 17:41
 *@DESC
 */
public class ExcelWriteWithTemplate {


    public static void main(String[] args) {
        try {
            InputStream excelIs = ClassLoader.getSystemClassLoader().getResourceAsStream("template.xls");
            Workbook workbook = WorkbookFactory.create(excelIs);
            Sheet sheet = workbook.getSheet("Sheet0");
            ExcelWriteWithTemplate template = new ExcelWriteWithTemplate(workbook, sheet);
            template.insertData(new HashMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Workbook workbook;
    private Sheet sheet;

    public ExcelWriteWithTemplate(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void m(InputStream ins) throws IOException {
        Workbook workbook = WorkbookFactory.create(ins);
        int numberOfSheets = workbook.getNumberOfSheets();
    }

    public void insertData(Map map) throws IOException {
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < physicalNumberOfRows; i++) {
            Row row = sheet.getRow(i);
            if (null != row) {
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                for (int j = 0; j < physicalNumberOfCells; j++) {
                    Cell cell = row.getCell(j);
                    if (null == cell) {
                        continue;
                    } else {
                        Result mergedResult = getMergedRange(cell);
                        boolean merged = mergedResult.isMerged();
                        if (merged) {
                            if (mergedResult.isFirstCellInMerge){
                                String var = cell.getStringCellValue();
                                TemplateExpression var2 = new TemplateExpression(var);
                                ValueType type = var2.getType();
                                
                            }

                            System.out.println("合并单元格，第" + i + "行,第" + j + "列");
                        } else {
                            System.out.println("非合并单元格，第" + i + "行,第" + j + "列");
                        }
                    }
                }
            } else {
                continue;
            }
        }
        workbook.write(new FileOutputStream("E:\\workspace\\github\\git_opt\\src\\main\\resources\\data.xls"));
    }

    public Result getMergedRange(Cell cell) {
        Result var = null;
        List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
        if (CollectionUtils.isEmpty(mergedRegions)) {
            var = new Result(false, false, null);
        }
        int columnIndex = cell.getColumnIndex();
        int rowIndex = cell.getRowIndex();
        outer:
        for (CellRangeAddress rangeAddress : mergedRegions) {
            int firstColumnIndex = rangeAddress.getFirstColumn();
            int lastColumnIndex = rangeAddress.getLastColumn();
            int firstRowIndex = rangeAddress.getFirstRow();
            int lastRowIndex = rangeAddress.getLastRow();
            if (columnIndex >= firstColumnIndex && columnIndex <= lastColumnIndex && rowIndex >= firstRowIndex && rowIndex <= lastRowIndex) {
                if (columnIndex == firstColumnIndex && rowIndex == firstRowIndex) {
                    return new Result(true, true, rangeAddress);

                } else {
                    return new Result(true, false, rangeAddress);

                }
            }
        }
        return new Result(false, false, null);
    }


    class Result {
        private boolean isMerged;
        private boolean isFirstCellInMerge;
        private CellRangeAddress cellAddresses;

        public Result(boolean isMerged, boolean isFirstCellInMerge, CellRangeAddress cellAddresses) {
            this.isMerged = isMerged;
            this.isFirstCellInMerge = isFirstCellInMerge;
            this.cellAddresses = cellAddresses;
        }

        public boolean isMerged() {
            return isMerged;
        }

        public void setMerged(boolean merged) {
            isMerged = merged;
        }

        public boolean isFirstCellInMerge() {
            return isFirstCellInMerge;
        }

        public void setFirstCellInMerge(boolean firstCellInMerge) {
            isFirstCellInMerge = firstCellInMerge;
        }

        public CellRangeAddress getCellAddresses() {
            return cellAddresses;
        }

        public void setCellAddresses(CellRangeAddress cellAddresses) {
            this.cellAddresses = cellAddresses;
        }
    }
}

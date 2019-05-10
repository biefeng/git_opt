package com.biefeng.excel;
import java.io.*;
import com.artofsolving.jodconverter.openoffice.connection.*;
import com.artofsolving.jodconverter.openoffice.converter.*;
import com.artofsolving.jodconverter.*;

public class ExcelToPdf {

    public static void main(String[] args) throws Exception {

// Link to the instance of OpenOffice.org that is running in the background
        OpenOfficeConnection OpenOfficeConnection = new SocketOpenOfficeConnection(8100);
        OpenOfficeConnection.connect();

        File inputFile = new File("d:\\test_1.xls");
        File outputFile = new File("d:\\doc\\openoffice\\test_1.pdf");

//convert the spreadsheet
        DocumentConverter documentConverter = new OpenOfficeDocumentConverter(OpenOfficeConnection);

        DocumentFormat documentFormat = new DocumentFormat();

        documentConverter.convert(inputFile, outputFile);

        OpenOfficeConnection.disconnect();
    }
}
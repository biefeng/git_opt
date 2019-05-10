package com.biefeng.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author BieFeNg
 *@Date 2019/5/10 11:56
 *@DESC
 */
public class PdfToImage {
    private static List<BufferedImage> pdfToImage(InputStream is) {
        List<BufferedImage> list = new ArrayList<>();
        try {
            PDDocument doc = PDDocument.load(is);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                // 方式1,第二个参数是设置缩放比(即像素)
                // BufferedImage image = renderer.renderImageWithDPI(i, 296);
                // 方式2,第二个参数是设置缩放比(即像素)
                BufferedImage image = renderer.renderImage(i, 2.0f, ImageType.BINARY);  //第二个参数越大生成图片分辨率越高，转换时间也就越长
                list.add(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<BufferedImage> images = pdfToImage(new FileInputStream("d:/doc/openoffice/test_1.pdf"));
        for (BufferedImage image:images){
            ImageIO.write(image,"bmp",new FileOutputStream("d:/doc/openoffice/test_1.bmp"));
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.utilitario;

import com.barcodelib.barcode.QRCode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Darwin
 */
public class CodigoQR {

    private static int uom = 0;        //  0 - Pixel, 1 - CM, 2 - Inch
    private static int resolution = 72;
    private static float leftMargin = 80.000f;
    private static float rightMargin = 80.000f;
    private static float topMargin = 80.000f;
    private static float bottomMargin = 80.000f;
    private static int rotate = 0;     //  0 - 0, 1 - 90, 2 - 180, 3 - 270
    private static float moduleSize = 5.000f;
    private static byte[] valores;

    public static byte[] generarCodigoQR() {
        try {
            //generar codigo aleatori
            Date d = new Date();
            String pathQR = "F://" + d.getTime() + ".gif";
            QRCode barcode = new QRCode();
            barcode.setData("CODIGO QR GENERADO PARA JORGE PANTOJA");
            barcode.setDataMode(QRCode.MODE_BYTE);
            barcode.setVersion(10);
            barcode.setEcl(QRCode.ECL_M);

            barcode.setUOM(uom);
            barcode.setModuleSize(moduleSize);
            barcode.setLeftMargin(leftMargin);
            barcode.setRightMargin(rightMargin);
            barcode.setTopMargin(topMargin);
            barcode.setBottomMargin(bottomMargin);
            barcode.setResolution(resolution);
            barcode.setRotate(rotate);


            barcode.renderBarcode(pathQR);
            System.out.println("ingresa a crear");
            valores = Imagen_A_Bytes(pathQR);
        } catch (Exception e) {

            System.out.println("fallo  " + e.getMessage());
        }
        return valores;
    }

    public static byte[] Imagen_A_Bytes(String path) throws FileNotFoundException {
        File file = new File(path);

        FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum);
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
        }

        byte[] bytes = bos.toByteArray();
        return bytes;
    }
}

/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.barcodelib.barcode.QRCode;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;

/**
 *
 * @author gato
 */
public class Administrar {

    private static int uom = 0;        //  0 - Pixel, 1 - CM, 2 - Inch
    private static int resolution = 72;
    private static float leftMargin = 80.000f;
    private static float rightMargin = 80.000f;
    private static float topMargin = 80.000f;
    private static float bottomMargin = 80.000f;
    private static int rotate = 0;     //  0 - 0, 1 - 90, 2 - 180, 3 - 270
    private static float moduleSize = 5.000f;

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) throws Exception {
        Selectors.wireComponents(view, this, false);

    }

    public Administrar() {
        try {
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

            barcode.renderBarcode("f://qrcode.gif");
            System.out.println("ingresa a crear");
        } catch (Exception e) {

            System.out.println("fallo  " + e.getMessage());
        }
    }

    @Command
    @NotifyChange({"listaRutas"})
    public void doRutas() {
        Executions.sendRedirect("/administrar/rutas.zul");
    }
}
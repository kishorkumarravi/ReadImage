package com.kkr.readImage.service.impl;

import com.kkr.readImage.resource.ReadImageController;
import com.kkr.readImage.service.ReadImageService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author kravi
 * @since 11/14/18 11:08 AM
 */
@Service
public class ReadImageServiceImpl implements ReadImageService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReadImageServiceImpl.class);

    public String convertImagetoText (File file) throws TesseractException {
        String convertedText = "";

        //String filePath = "/Macintosh HD/Users/krav/Downloads/pictures-with-words.jpg";
        LOGGER.debug("File path : {}", file);

        /*File imageFile = new File(file);*/

        if (file.exists()) {
            ITesseract tesseract = new Tesseract();

            String result = tesseract.doOCR(file);
            System.out.println(result);
        }
        else {
            System.out.println("File not found!!!");
        }

        ITesseract instance = new Tesseract();
        try {
            convertedText = instance.doOCR(file);

        } catch (TesseractException e) {
            System.err.println(e.getMessage());
            return "Error while reading image";
        }

        return convertedText;
    }

}

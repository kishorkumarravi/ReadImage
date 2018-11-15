package com.kkr.readImage.service.impl;

import com.kkr.readImage.resource.ReadImageController;
import com.kkr.readImage.service.ReadImageService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

        File file1 = new File("/Users/kravi/Downloads/33.png");

        //public File img = new File("imagen.png");

        BufferedImage buffImg =
                new BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB);

        try {
            buffImg = ImageIO.read(file1);
        }
        catch (IOException e) { }

        System.out.println(buffImg.getType()); //Prints 0 instead of 2


        if (file1.exists()) {
            ITesseract tesseract = new Tesseract();

            String result = tesseract.doOCR(buffImg);
            System.out.println(result);
        }
        else {
            System.out.println("File not found!!!");
        }


        return convertedText;
    }

}

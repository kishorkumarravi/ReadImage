package com.kkr.readImage.resource;

import com.kkr.readImage.service.ReadImageService;
import io.swagger.annotations.Api;
import net.sourceforge.tess4j.TesseractException;
import org.hibernate.validator.internal.engine.messageinterpolation.FormatterWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.text.resources.FormatData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author kravi
 * @since 11/14/18 10:53 AM
 */
@RestController
@RequestMapping("/readImage/")
@Api(value = "/readImage/" , description="Operations for reading text in an image")
public class ReadImageController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReadImageController.class);

    @Autowired
    ReadImageService readImageService;
    /**
     * This method reads the content present in an image
     * @return String This returns string content present in the incoming image
     */
    @RequestMapping(value = "all", method = POST)
    @ResponseBody
    public String readImage(@RequestParam("file") MultipartFile multipartFile) throws TesseractException, IOException {
        LOGGER.info("Inside Read image method..");

        File file = convert(multipartFile);
        return readImageService.convertImagetoText(file);

    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}

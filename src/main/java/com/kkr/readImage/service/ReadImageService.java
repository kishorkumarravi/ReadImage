package com.kkr.readImage.service;

import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @author kravi
 * @since 11/14/18 11:08 AM
 */
public interface ReadImageService {

    String convertImagetoText (File file) throws TesseractException;

}

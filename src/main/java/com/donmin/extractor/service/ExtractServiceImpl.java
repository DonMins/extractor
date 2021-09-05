package com.donmin.extractor.service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;
import org.apache.tika.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ExtractServiceImpl implements ExtractService {
    Logger log = Logger.getLogger(ExtractServiceImpl.class.getName());

    @Override
    public String extractTextFromImage(BufferedImage image) {
        try {
            ITesseract tesseract = new Tesseract();

            tesseract.setDatapath("D:\\IdeaProjects\\extractor\\src\\main\\tessdata");
            tesseract.setLanguage("rus+eng");

            String str = tesseract.doOCR(image);
            return str.replaceAll("\n{2,}"," ");
        }
        catch (TesseractException ex){
            log.error("Error: " + ex.getMessage());
        }
        return StringUtils.EMPTY;
    }
}

package com.donmin.extractor.service;

import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ExtractService {
    String extractTextFromImage(BufferedImage image) throws IOException, TesseractException;
}

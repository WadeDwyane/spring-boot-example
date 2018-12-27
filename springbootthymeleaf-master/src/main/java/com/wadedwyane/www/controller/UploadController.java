package com.wadedwyane.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 使用thymeleaf模板引擎实现文件上传
 */
@Controller
public class UploadController {

    private static String UPLOADED_FOLDER = "E://temp//";

    @RequestMapping("/")
    public String index() {
        return "upload";
    }

    /**
     * 模仿单个文件上传
     *
     * @param file
     * @param attributes
     * @return
     */
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "please select a file");
            return "redirect:/upload_result";
        }

        try {
            byte[] bytes = file.getBytes();
            //本地文件存储地址
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            attributes.addFlashAttribute("message", "You sucessfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/upload_result";
    }

    @RequestMapping("/more")
    public String uploadMore() {
        return "more";
    }

    @RequestMapping("/uploadMore")
    public String moreFileUpload(@RequestParam("file") MultipartFile[] files, RedirectAttributes attributes) {
        if (files.length == 0) {
            attributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:upload_result";
        }
        //单个文件上传,文件批量上传如何做?
        for (MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        attributes.addFlashAttribute("message", "You successfully uploaded all");
        return "redirect:/upload_result";
    }

    @RequestMapping("/upload_result")
    public String uploadResult() {
        return "upload_result";
    }

}

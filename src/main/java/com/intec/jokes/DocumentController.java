package com.intec.jokes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doc")
public class DocumentController {

     @Autowired
     DocumentService docService;

     @PostMapping("save")
     public void saveDoc(@RequestParam String name, @RequestParam Integer id) {
          docService.saveDoc(id, name);
     }

     @GetMapping("list")
     public List<Document> listDocs() {
          return docService.getDocs();
     }
}

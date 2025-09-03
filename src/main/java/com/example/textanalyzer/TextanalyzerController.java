package com.example.textanalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/analyze")
public class TextanalyzerController {

    @Autowired
    private TextanalyzerService analyzerService;

    @PostMapping
    public ResponseEntity<List<LetterResult>> analyze(@RequestParam String mode, @RequestBody TextRequest request) {
        String text = request.getText();
        if (mode.equals("vowels")) {
            return ResponseEntity.ok(analyzerService.analyzeVowels(text));
        } else {
            return ResponseEntity.ok(analyzerService.analyzeConsonants(text));
        }
    }
}

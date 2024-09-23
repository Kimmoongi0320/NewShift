package Shift.ShiftBack.domain.keyword.controller;

import Shift.ShiftBack.domain.keyword.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class KeywordController {
    private final KeywordService keywordService;

    @GetMapping("/get_epa_keywords")
    public ResponseEntity<Map<Integer, List<String>>> getEpaKeywords() throws IOException {

        keywordService.loadKeywords();
        Map<Integer, List<String>> keywords = keywordService.getKeywordDict();

        return ResponseEntity.ok(keywords);
    }
}

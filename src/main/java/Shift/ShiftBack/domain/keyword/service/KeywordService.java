package Shift.ShiftBack.domain.keyword.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class KeywordService {
    private List<String> keywordList;
    private Map<Integer, List<String>> keywordDict;

    public void loadKeywords() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Shift/ShiftBack/domain/keyword/repository/keywords.txt"))) {
            keywordList = new ArrayList<>();

            String line;
            // 각 라인을 읽어서 조건에 맞는 키워드만 리스트에 추가
            while ((line = reader.readLine()) != null) {
                if (line.length() > 2 && line.charAt(0) != '#') {
                    keywordList.add(line);
                }
            }
        }


        String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);
        // 키워드를 Map에 저장하는 로직
        keywordDict = new HashMap<>();
        for (int i = 0; i < keywordList.size(); i++) {
            if (i < 13) {
                // 인덱스 +1에 저장
                keywordDict.put(i + 1, List.of(keywordList.get(i).split(",")));
            } else {
                // 인덱스 +2에 저장
                keywordDict.put(i + 2, List.of(keywordList.get(i).split(",")));
            }
        }
    }

}

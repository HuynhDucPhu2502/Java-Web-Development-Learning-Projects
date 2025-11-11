package me.huynhducphu.shoppingapp.service.impl;

import me.huynhducphu.shoppingapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Admin 11/10/2025
 *
 **/
@Service
@RequiredArgsConstructor
public class GeminiServiceImpl {

    @Value("${app.gemini.api.key}")
    private String geminiApiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ProductRepository productRepo;


    public String generateContent(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + geminiApiKey;

        String context = productRepo.findAll().stream()
                .map(p -> String.format("%s (%.2f)", p.getName(), p.getPrice()))
                .reduce("", (a, b) -> a + "\n" + b);

        String question = """
                Bạn là chatbot tư vấn sản phẩm.
                Dữ liệu sản phẩm:
                %s
                ---
                Câu hỏi người dùng: %s
                """.formatted(context, prompt);


        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(Map.of("text", question)))
                )
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Map content = (Map) ((List) response.getBody().get("candidates")).get(0);
            Map part = (Map) ((List) ((Map) content.get("content")).get("parts")).get(0);
            return (String) part.get("text");
        }

        return "Lỗi khi gọi Gemini API";
    }
}

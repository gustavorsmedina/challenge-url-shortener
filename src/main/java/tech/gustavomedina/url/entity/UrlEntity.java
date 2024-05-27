package tech.gustavomedina.url.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Builder
@Document(collection = "urls")
public class UrlEntity {

    @Id
    private String id;
    private String originalUrl;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

}

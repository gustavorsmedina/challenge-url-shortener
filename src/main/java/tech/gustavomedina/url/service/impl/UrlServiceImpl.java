package tech.gustavomedina.url.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.gustavomedina.url.exception.UrlExpiredException;
import tech.gustavomedina.url.exception.UrlNotFoundException;
import tech.gustavomedina.url.dto.UrlRequest;
import tech.gustavomedina.url.entity.UrlEntity;
import tech.gustavomedina.url.repository.UrlRepository;
import tech.gustavomedina.url.service.UrlService;
import tech.gustavomedina.url.util.RandomString;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    @Value("${url.expiration-time}")
    private Long expirationTime;

    private final UrlRepository urlRepository;

    @Override
    public String shortenUrl(UrlRequest urlRequest) {

        String randomUrl;

        do{
           randomUrl = RandomString.generate();
        } while(urlRepository.existsById(randomUrl));

        var url = UrlEntity.builder()
                        .id(randomUrl)
                        .originalUrl(urlRequest.url())
                        .createdAt(LocalDateTime.now())
                        .expiresAt(LocalDateTime.now().plusMinutes(expirationTime))
                        .build();

        var savedUrl = urlRepository.save(url);

        return savedUrl.getId();
    }

    @Override
    public String getUrl(String id) {

        var url = urlRepository.findById(id).orElseThrow(() -> new UrlNotFoundException("The URL doesn't exist."));

        if(LocalDateTime.now().isAfter(url.getExpiresAt())){
            throw new UrlExpiredException("The URL is expired.");
        }

        return url.getOriginalUrl();
    }
}

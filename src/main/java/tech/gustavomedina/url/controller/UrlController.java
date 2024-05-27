package tech.gustavomedina.url.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.gustavomedina.url.exception.UrlExpiredException;
import tech.gustavomedina.url.exception.UrlNotFoundException;
import tech.gustavomedina.url.dto.UrlRequest;
import tech.gustavomedina.url.dto.UrlResponse;
import tech.gustavomedina.url.service.UrlService;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/v1/shorten-url")
    public ResponseEntity<UrlResponse> shortenUrl(@RequestBody UrlRequest urlRequest, HttpServletRequest httpRequest){

        log.info("Shortening the URL: {}", urlRequest.url());
        var urlId = urlService.shortenUrl(urlRequest);

        var shortenedUrl = httpRequest.getRequestURL().toString()
                .replace(httpRequest.getRequestURI(), "/" + urlId);

        log.info("URL shortened to: {}", shortenedUrl);

        var url = UrlResponse.builder()
                .url(shortenedUrl)
                .build();

        return ResponseEntity.ok(url);
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirectUrl(@PathVariable("id") String id){

        try{
            var originalUrl = urlService.getUrl(id);

            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", originalUrl)
                    .build();
        } catch (UrlNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch(UrlExpiredException ex){
            return ResponseEntity.status(HttpStatus.GONE).build();
        }

    }

}

package tech.gustavomedina.url.service;

import tech.gustavomedina.url.dto.UrlRequest;
import tech.gustavomedina.url.dto.UrlResponse;

public interface UrlService {

    String shortenUrl(UrlRequest urlRequest);
    String getUrl(String id);

}

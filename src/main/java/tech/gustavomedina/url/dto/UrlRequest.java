package tech.gustavomedina.url.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlRequest(@NotBlank String url) {
}

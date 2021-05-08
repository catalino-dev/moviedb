package com.ccomision.moviedb.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TmdbRequestInterceptor implements ClientHttpRequestInterceptor {

	private final TmdbProperties tmdbProperties;

	public TmdbRequestInterceptor(TmdbProperties tmdbProperties) {
		this.tmdbProperties = tmdbProperties;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		HttpHeaders httpHeaders = request.getHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setBearerAuth(tmdbProperties.getApiKey());
		return execution.execute(request, body);
	}
}

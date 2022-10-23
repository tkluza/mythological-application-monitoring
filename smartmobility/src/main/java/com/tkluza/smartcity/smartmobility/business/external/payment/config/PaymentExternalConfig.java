package com.tkluza.smartcity.smartmobility.business.external.payment.config;

import com.tkluza.smartcity.smartmobility.business.external.payment.PaymentExternalFacade;
import com.tkluza.smartcity.smartmobility.business.external.payment.PaymentExternalFacadeAdapter;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.PaymentExternalHttpClient;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.adapter.PaymentExternalHttpClientAdapter;
import com.tkluza.smartcity.smartmobility.business.external.payment.mapper.PaymentExternalMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PaymentExternalConfig {

    @Value("${smart-mobility.http-client.payment-application-url}")
    private String paymentApplicationUrl;

    @Bean
    public PaymentExternalFacade paymentExternalFacade() {
        WebClient webClient = WebClient.create(paymentApplicationUrl);
        PaymentExternalMapper paymentExternalMapper = new PaymentExternalMapper();
        PaymentExternalHttpClient httpClient = new PaymentExternalHttpClientAdapter(
                webClient,
                paymentExternalMapper
        );

        return new PaymentExternalFacadeAdapter(httpClient);
    }
}

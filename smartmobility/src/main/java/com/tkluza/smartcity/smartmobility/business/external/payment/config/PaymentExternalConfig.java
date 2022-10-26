package com.tkluza.smartcity.smartmobility.business.external.payment.config;

import com.tkluza.smartcity.smartmobility.business.external.payment.PaymentExternalFacade;
import com.tkluza.smartcity.smartmobility.business.external.payment.PaymentExternalFacadeAdapter;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.PaymentExternalHttpClient;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.adapter.PaymentExternalHttpClientAdapter;
import com.tkluza.smartcity.smartmobility.business.external.payment.mapper.PaymentExternalMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PaymentExternalConfig {

    @Bean
    public PaymentExternalFacade paymentExternalFacade(PaymentExternalProperties paymentExternalProperties) {
        WebClient webClient = WebClient.create(paymentExternalProperties.paymentApplicationUrl());
        PaymentExternalMapper paymentExternalMapper = new PaymentExternalMapper();
        PaymentExternalHttpClient httpClient = new PaymentExternalHttpClientAdapter(
                webClient,
                paymentExternalMapper,
                paymentExternalProperties.networkLatencyMillis()
        );

        return new PaymentExternalFacadeAdapter(httpClient);
    }
}

package com.tkluza.smartcity.smartmobility.business.external.payment.config;

import com.tkluza.smartcity.smartmobility.business.external.payment.PaymentExternalFacade;
import com.tkluza.smartcity.smartmobility.business.external.payment.PaymentExternalFacadeAdapter;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.PaymentExternalHttpClient;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.adapter.PaymentExternalHttpClientAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentExternalConfig {

    @Bean
    public PaymentExternalFacade paymentExternalFacade() {
        PaymentExternalHttpClient httpClient = new PaymentExternalHttpClientAdapter();

        return new PaymentExternalFacadeAdapter(httpClient);
    }
}

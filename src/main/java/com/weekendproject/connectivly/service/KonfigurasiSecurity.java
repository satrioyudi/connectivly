/*package com.weekendproject.connectivly.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity()
@EnableResourceServer
public class KonfigurasiSecurity extends ResourceServerConfigurerAdapter {
	
	@Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.resourceId("testjwt").tokenServices(tokenServices());
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
    
    @Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.cors().and()
		.authorizeRequests().anyRequest().authenticated();
	}
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
    	corsConfiguration.addAllowedHeader("PUT");
    	corsConfiguration.addExposedHeader("Content-Disposition");
    	
    	source.registerCorsConfiguration("/**", corsConfiguration);
    	return source;
    }
}
*/
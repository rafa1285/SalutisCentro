package es.salutiscentro.gestion;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import es.salutiscentro.gestion.interceptor.LoginInterceptor;

/**
 * Configurador de la app. La configuración de acceso a datos se encuentra en
 * application.properties
 * 
 * @author Rafael Justo
 *
 */
@Configuration
public class SpringConfiguration implements WebMvcConfigurer {

	/**
	 * Para decirle al interceptor cual va a ser el idioma por defecto
	 * 
	 * @return devuelve el idioma por defecto
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("es"));
		return localeResolver;
	}

	/**
	 * Para establecerle al interceptor el idioma elegido en caso de que hubiera
	 * varios
	 * 
	 * @return devuelve un interceptor con la configuracion seleccionada del idioma.
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	/**
	 * Se establece el Encoding de la aplicacion
	 * 
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("LATIN1");
		return messageSource;
	}

	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	/**
	 * Metodo donde le decimos al interceptor que paginas excluimos para que no pase
	 * por el
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		// Excluimos los estaticos para el diseño
		registry.addInterceptor(loginInterceptor()).excludePathPatterns("/css/*").excludePathPatterns("/fotos/*")
				.excludePathPatterns("/images/*").excludePathPatterns("/js/*");
	}

	/**
	 * Metodo donde establecemos el fichero para usar las Tiles y decimos en que
	 * ruta esta
	 * 
	 * @return devuelve la configuracion de un Tiles
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
		return tiles;
	}

	/**
	 * Para resolver las vistas con las tiles en vez de con paginas jsp
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// registry.jsp("/", ".jsp");
		// configuracion con tiles
		registry.tiles();
	}

	/**
	 * Dirigir a index en inicio de app
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}

}

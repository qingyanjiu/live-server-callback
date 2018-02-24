package louis.live.server.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
open class WebConfig : WebMvcConfigurerAdapter() {

    override fun addCorsMappings(registry: CorsRegistry?) {
        registry?.addMapping("/**")
                ?.allowedOrigins("*")
                ?.allowedMethods("GET", "POST")
                ?.allowCredentials(false)
                ?.maxAge(3600)
    }

}
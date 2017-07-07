package kjkrol.eshop.exposedcontent.config

import com.google.common.base.Predicate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import com.google.common.base.Predicates.not
import springfox.documentation.builders.PathSelectors.regex

@Configuration
@EnableSwagger2
internal class SwaggerConfiguration {

    @Value("\${management.contextPath}.*")
    private val actuatorPath: String? = null

    private fun actuatorRegex(): Predicate<String> {
        return regex(actuatorPath)
    }

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("all-api")
                .enableUrlTemplating(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(not(regex("/error.*")))
                .paths(not(actuatorRegex()))
                .build()
    }
}
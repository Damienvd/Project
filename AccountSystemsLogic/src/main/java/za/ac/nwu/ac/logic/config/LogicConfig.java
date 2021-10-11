package za.ac.nwu.ac.logic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.translator.Config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = {"za.az.nwu.ac.logic.flow",
                            "za.ac.nwu.ac.logic.flow.impl"})
public class LogicConfig {
}

package org.me.demo.configurationfile.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "dbtypes")
@Component
@Data
public class Dbtypes {
    private Integer id;
    private List<String> name;
}

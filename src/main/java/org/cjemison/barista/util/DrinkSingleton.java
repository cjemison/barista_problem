package org.cjemison.barista.util;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

public class DrinkSingleton {
    private static DrinkSingleton instance;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<DrinkType, List<DrinkObject>> map = null;

    protected DrinkSingleton() {

    }

    public static DrinkSingleton getInstance() {
        if (instance == null) {
            instance = new DrinkSingleton();
            instance.init();
        }
        return instance;
    }

    public void init() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.map = mapper.readValue(new File("drinks.json"), new TypeReference<Map<DrinkType, List<DrinkObject>>>() {
            });
        } catch (Exception e) {
            this.logger.error("### ERROR ###", e);
        }
    }

    public Map<DrinkType, List<DrinkObject>> getMap() {
        return map;
    }
}

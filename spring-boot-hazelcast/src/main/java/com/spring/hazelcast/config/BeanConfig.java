package com.spring.hazelcast.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Config hazelCastConfig(){
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("employees");
        EvictionConfig evictionConfig = new EvictionConfig();
        evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
        mapConfig.setEvictionConfig(evictionConfig);
        mapConfig.setMaxIdleSeconds(20);
        return new Config().setInstanceName("hazelcast-instance").addMapConfig(mapConfig);
//      .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
    }

    @Bean
    public Config configuration(){
        Config config = new Config();
        config.setInstanceName("hazelcast-instance");
        MapConfig mapConfig= new MapConfig();
        mapConfig.setName("configuration");
//        mapConfig.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE));
//        mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
        mapConfig.setTimeToLiveSeconds(-1);
        config.addMapConfig(mapConfig);
        return config;
    }
}

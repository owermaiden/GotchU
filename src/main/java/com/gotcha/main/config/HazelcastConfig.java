package com.gotcha.main.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    public Config hazelCastConfig(){
        Config config = new Config();
        config.getJetConfig().setEnabled(true);
        config.getNetworkConfig().setPortAutoIncrement(true);
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(true);
        config.setInstanceName("hazelcast-instance");
        config.addMapConfig(mapConfig());

        config.addCacheConfig(new CacheSimpleConfig()
                .setName("users")
                .setEvictionConfig(new EvictionConfig()
                        .setMaxSizePolicy(MaxSizePolicy.PER_NODE)
                        .setSize(1000)
                        .setEvictionPolicy(EvictionPolicy.LRU))
        );

        config.addMapConfig(new MapConfig()
                .setName("categories")
                .setTimeToLiveSeconds(300)
                .setMaxIdleSeconds(400)
        );

        return config;
    }

    private MapConfig mapConfig() {
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("products");
        mapConfig.setTimeToLiveSeconds(360);
        mapConfig.setMaxIdleSeconds(400);
        return mapConfig;
    }



}

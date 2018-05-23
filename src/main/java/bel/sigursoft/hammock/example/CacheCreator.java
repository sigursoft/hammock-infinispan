package bel.sigursoft.hammock.example;

import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.cdi.embedded.ConfigureCache;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import javax.enterprise.inject.Produces;
import javax.enterprise.context.ApplicationScoped;

public class CacheCreator {

    @Produces
    @ApplicationScoped
    public EmbeddedCacheManager cacheManager() {
      EmbeddedCacheManager manager = new DefaultCacheManager(globalConfiguration(), defaultConfiguration(), true);
      return manager;
    }

    @Produces
    @SmallCache
    @ConfigureCache("small")
    public Configuration smallCacheConfiguration() {
      Configuration smallCacheConfiguration = customCacheConfiguration();
      return smallCacheConfiguration;
    }

    private GlobalConfiguration globalConfiguration() {
      GlobalConfiguration glob = new GlobalConfigurationBuilder().defaultCacheName("bucket").nonClusteredDefault().build();
      return glob;
    }

    private Configuration defaultConfiguration() {
      ConfigurationBuilder builder = new ConfigurationBuilder();
      Configuration configuration = builder.eviction().strategy(EvictionStrategy.LRU).maxEntries(1500).build();
      return configuration;
    }

    private Configuration customCacheConfiguration() {
      ConfigurationBuilder builder = new ConfigurationBuilder();
      Configuration configuration = builder.eviction().strategy(EvictionStrategy.LIRS).maxEntries(10).build();
      return configuration;
    }

}

package hoon.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class CacheConfig {
    // NOTE #11 @EnableCaching 가 있어야  cache 가 동작합니다.

    @Bean
    public CacheManager cacheManager() {
        // 로컬 캐시 & 힙 메모리 & 가비지 컬렉션과의 관계는?
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(generateCacheName());
        return cacheManager;
    }

    private List<Cache> generateCacheName() {
        Cache cache = new ConcurrentMapCache("MemberGroup");
        return Collections.singletonList(cache);
    }
}

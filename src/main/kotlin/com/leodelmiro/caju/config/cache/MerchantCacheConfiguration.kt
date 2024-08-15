package com.leodelmiro.caju.config.cache

import com.leodelmiro.caju.adapters.out.repository.MerchantRepository
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableCaching
@EnableScheduling
class MerchantCacheConfiguration {

    @Bean
    @Primary
    fun merchantCacheManager() = ConcurrentMapCacheManager(CACHE_MERCHANT)

    @Bean
    fun cacheMerchantHandler(merchantRepository: MerchantRepository, cacheManager: CacheManager) =
        MerchantCacheHandler(merchantRepository, cacheManager)


    companion object {
        const val CACHE_MERCHANT = "merchant"
    }
}
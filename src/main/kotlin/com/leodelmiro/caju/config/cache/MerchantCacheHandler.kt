package com.leodelmiro.caju.config.cache

import com.leodelmiro.caju.adapters.out.repository.MerchantRepository
import com.leodelmiro.caju.config.cache.MerchantCacheConfiguration.Companion.CACHE_MERCHANT
import org.springframework.beans.factory.InitializingBean
import org.springframework.cache.CacheManager
import org.springframework.scheduling.annotation.Scheduled

class MerchantCacheHandler(
    private val merchantRepository: MerchantRepository,
    private val cacheManager: CacheManager
) : InitializingBean {

    override fun afterPropertiesSet() {
        updateCache()
    }

    @Scheduled(initialDelayString = "\${merchant.cache.ttl}", fixedDelayString = "\${merchant.cache.ttl}")
    fun refreshCache() {
        clearCache()
        updateCache()
    }

    private fun clearCache() {
        this.cacheManager.getCache(CACHE_MERCHANT)?.invalidate()
    }

    private fun updateCache() = this.merchantRepository.findAll().forEach {
        it.name.let { name -> this.cacheManager.getCache(CACHE_MERCHANT)?.put(requireNotNull(name), it) }
    }

}
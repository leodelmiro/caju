package com.leodelmiro.caju.adapters.out.repository

import com.leodelmiro.caju.adapters.out.repository.entity.MerchantEntity
import com.leodelmiro.caju.config.cache.MerchantCacheConfiguration.Companion.CACHE_MERCHANT
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository : JpaRepository<MerchantEntity, Long> {

    @Cacheable(CACHE_MERCHANT)
    fun findMerchantByName(name: String): MerchantEntity?
}
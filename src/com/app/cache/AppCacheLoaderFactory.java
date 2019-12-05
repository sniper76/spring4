package com.app.cache;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.app.dao.ComMDao;

public class AppCacheLoaderFactory {
	
	private EhCacheCacheManager cacheManager;
	
	private ComMDao comMDao;

	public void setCacheManager(EhCacheCacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public void setComMDao(ComMDao comMDao) {
		this.comMDao = comMDao;
	}
	
	@PostConstruct
	private void init() {
		List<Map<String, Object>> codeList = comMDao.selectCodes();
//		for (Map<String, Object> map : codeList) {
//			System.out.println(map);
//		}
		
		EhCacheCache cache = (EhCacheCache)cacheManager.getCache("codeCache");
		if (cache.get("codes") == null) {
			cache.put("codes", codeList);
		}
	}
}

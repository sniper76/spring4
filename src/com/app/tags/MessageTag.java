package com.app.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.app.vo.MsgVO;

public class MessageTag extends SimpleTagSupport {
	private String sysCd;
	private String msgId;
	private String langCd;
	private String empty;
	
	public MessageTag() {
		
	}

	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}

	public void setEmpty(String empty) {
		this.empty = empty;
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			MsgVO msgVO = new MsgVO();
			msgVO.setEmpty(empty);
			msgVO.setLangCd(langCd);
			msgVO.setMsgId(msgId);
			msgVO.setSysCd(sysCd);
			
			PageContext context = (PageContext) getJspContext();
	        HttpServletRequest request = (HttpServletRequest) context.getRequest();
	        ApplicationContext appContext = RequestContextUtils.findWebApplicationContext(request);
	        
	        // bean 주입
	        EhCacheCacheManager cacheManager = (EhCacheCacheManager) appContext.getBean("ehCacheManager");

			EhCacheCache cache = (EhCacheCache)cacheManager.getCache("codeCache");
			
			String msg = "empty " + msgVO.getEmpty();
			
			if (cache.get("codes") != null) {
				ValueWrapper vw = cache.get("codes");
				List<Map<String, Object>> lst = (List<Map<String, Object>>)vw.get();
				for (Map<String, Object> map : lst) {
					if (msgId.equals(map.get("code_id").toString())) {
						msg = map.get("code_name").toString();
						break;
					}
				}
			}
			
			getJspContext().getOut().write(msg);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

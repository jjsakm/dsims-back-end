package egovframework.com.edoc.clsf.service.impl;

import java.util.List;

import egovframework.com.edoc.clsf.domain.model.DocumentClassificationVO;

public interface DocumentClassificationService {
	DocumentClassificationVO select(String no);
	List<DocumentClassificationVO> getTopLevelList();
	List<DocumentClassificationVO> getChildren(String parentNo);
}

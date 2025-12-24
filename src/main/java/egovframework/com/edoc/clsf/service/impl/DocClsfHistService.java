package egovframework.com.edoc.clsf.service.impl;

import java.util.List;

import egovframework.com.edoc.clsf.domain.model.DocClsfHistVO;

public interface DocClsfHistService {
	List<DocClsfHistVO> selectListByDocClsfNo(String docClsfNo);

	int insert(DocClsfHistVO histVO);

	void deleteByDocClsfNo(String docClsfNo);
}

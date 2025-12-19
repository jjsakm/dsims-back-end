package egovframework.com.edoc.clsf.service.impl;

import java.util.List;

import egovframework.com.edoc.clsf.domain.model.DocClsfSearchVO;
import egovframework.com.edoc.clsf.domain.model.DocClsfVO;

public interface DocClsfService {
	DocClsfVO select(String docClsfNo);
	List<DocClsfVO> getTopLevelList();
	List<DocClsfVO> getChildren(String docClsfNo);
	List<DocClsfVO> selectList(DocClsfSearchVO searchVO);
	int selectListTotCnt(DocClsfSearchVO searchVO);
}

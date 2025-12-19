package egovframework.com.edoc.clsf.service.impl;

import java.util.List;

import egovframework.com.edoc.clsf.domain.model.DocClsfVO;
import egovframework.com.edoc.clsf.dto.request.DocClsfInsertRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfSearchRequestDto;

public interface DocClsfService {
	DocClsfVO select(String docClsfNo);
	List<DocClsfVO> getTopLevelList();
	List<DocClsfVO> getChildren(String docClsfNo);
	List<DocClsfVO> selectList(DocClsfSearchRequestDto searchRequestDto);
	int selectListTotCnt(DocClsfSearchRequestDto searchRequestDto);
	int insert(DocClsfInsertRequestDto insertRequestDto);
}

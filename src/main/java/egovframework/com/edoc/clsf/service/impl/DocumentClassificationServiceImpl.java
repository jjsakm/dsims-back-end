package egovframework.com.edoc.clsf.service.impl;
import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.edoc.clsf.domain.model.DocumentClassificationSearchVO;
import egovframework.com.edoc.clsf.domain.model.DocumentClassificationVO;
import egovframework.com.edoc.clsf.domain.repository.DocumentClassificationMapper;
import egovframework.com.edoc.clsf.enums.DocumentClassificationDivCode;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DocumentClassificationServiceImpl extends EgovAbstractServiceImpl  implements DocumentClassificationService{

    private final DocumentClassificationMapper documentClassificationMapper;

    @Override
    public DocumentClassificationVO select(String docClsfNo) {
    	return documentClassificationMapper.select(docClsfNo);
    }

	@Override
	public List<DocumentClassificationVO> getTopLevelList() {
		return documentClassificationMapper.selectListByDocClsfSeCd(DocumentClassificationDivCode.L.name());
	}

	@Override
	public List<DocumentClassificationVO> getChildren(String docClsfNo) {
		return documentClassificationMapper.selectListByUpDocClsfNo(docClsfNo);
	}

	@Override
	public List<DocumentClassificationVO> selectList(DocumentClassificationSearchVO searchVO) {
		return documentClassificationMapper.selectList(searchVO);
	}

	@Override
	public int selectListTotCnt(DocumentClassificationSearchVO searchVO) {
		return documentClassificationMapper.selectListTotCnt(searchVO);
	}
}

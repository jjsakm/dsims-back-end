package egovframework.com.edoc.clsf.service.impl;
import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.edoc.clsf.domain.model.DocClsfSearchVO;
import egovframework.com.edoc.clsf.domain.model.DocClsfVO;
import egovframework.com.edoc.clsf.domain.repository.DocClsfMapper;
import egovframework.com.edoc.clsf.enums.DocClsfSeCd;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DocClsfServiceImpl extends EgovAbstractServiceImpl  implements DocClsfService{

    private final DocClsfMapper docClsfMapper;

    @Override
    public DocClsfVO select(String docClsfNo) {
    	return docClsfMapper.select(docClsfNo);
    }

	@Override
	public List<DocClsfVO> getTopLevelList() {
		return docClsfMapper.selectListByDocClsfSeCd(DocClsfSeCd.L.name());
	}

	@Override
	public List<DocClsfVO> getChildren(String docClsfNo) {
		return docClsfMapper.selectListByUpDocClsfNo(docClsfNo);
	}

	@Override
	public List<DocClsfVO> selectList(DocClsfSearchVO searchVO) {
		return docClsfMapper.selectList(searchVO);
	}

	@Override
	public int selectListTotCnt(DocClsfSearchVO searchVO) {
		return docClsfMapper.selectListTotCnt(searchVO);
	}
}

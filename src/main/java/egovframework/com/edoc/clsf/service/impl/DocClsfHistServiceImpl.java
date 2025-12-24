package egovframework.com.edoc.clsf.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.edoc.clsf.domain.model.DocClsfHistVO;
import egovframework.com.edoc.clsf.domain.repository.DocClsfHistMapper;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DocClsfHistServiceImpl extends EgovAbstractServiceImpl implements DocClsfHistService {

	private final DocClsfHistMapper docClsfHistMapper;

	@Override
	public List<DocClsfHistVO> selectListByDocClsfNo(String docClsfNo) {
		return docClsfHistMapper.selectListByDocClsfNo(docClsfNo);
	}

	@Override
	public int insert(DocClsfHistVO histVO) {
		return docClsfHistMapper.insert(histVO);
	}

	@Override
	public void deleteByDocClsfNo(String docClsfNo) {
		docClsfHistMapper.deleteByDocClsfNo(docClsfNo);
	}


}

package egovframework.com.edoc.clsf.service.impl;

import java.util.List;
import java.util.UUID;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.edoc.clsf.domain.model.DocClsfVO;
import egovframework.com.edoc.clsf.domain.repository.DocClsfMapper;
import egovframework.com.edoc.clsf.domain.repository.PrvcFileHldPrstMapper;
import egovframework.com.edoc.clsf.dto.request.DocClsfInsertRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfSearchRequestDto;
import egovframework.com.edoc.clsf.enums.DocClsfSeCd;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DocClsfServiceImpl extends EgovAbstractServiceImpl implements DocClsfService {

	private final DocClsfMapper docClsfMapper;

	private final PrvcFileHldPrstMapper prvcFileHldPrstMapper;

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
	public List<DocClsfVO> selectList(DocClsfSearchRequestDto searchRequestDto) {
		return docClsfMapper.selectList(searchRequestDto);
	}

	@Override
	public int selectListTotCnt(DocClsfSearchRequestDto searchRequestDto) {
		return docClsfMapper.selectListTotCnt(searchRequestDto);
	}

	@Override
	public int insert(DocClsfInsertRequestDto insertRequestDto) {
		String docClsfNo = UUID.randomUUID().toString().substring(0, 20);
		insertRequestDto.setDocClsfNo(docClsfNo);
		int docClsfInsertRet = docClsfMapper.insert(insertRequestDto);
		if (docClsfInsertRet != 0 && isPrvcIncl(insertRequestDto)) {
			insertRequestDto.getPrvcFieldHldPrst().setDocClsfNo(docClsfNo);
			insertRequestDto.getPrvcFieldHldPrst().setPrvcFileHldPrstNo(UUID.randomUUID().toString().substring(0, 20));
			prvcFileHldPrstMapper.insert(insertRequestDto.getPrvcFieldHldPrst());
		}
		return docClsfInsertRet;
	}

	private boolean isPrvcIncl(DocClsfInsertRequestDto insertRequestDto) {
		return "Y".equals(insertRequestDto.getPrvcInclYn())
				&& DocClsfSeCd.S.name().equals(insertRequestDto.getDocClsfSeCd());
	}
}

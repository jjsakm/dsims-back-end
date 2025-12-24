package egovframework.com.edoc.clsf.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.edoc.clsf.domain.model.DocClsfVO;
import egovframework.com.edoc.clsf.domain.repository.DocClsfMapper;
import egovframework.com.edoc.clsf.domain.repository.PrvcFileHldPrstMapper;
import egovframework.com.edoc.clsf.dto.request.DocClsfInsertRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfSearchRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfUpdateRequestDto;
import egovframework.com.edoc.clsf.dto.request.exception.DuplicateNameException;
import egovframework.com.edoc.clsf.enums.DocClsfSeCd;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DocClsfServiceImpl extends EgovAbstractServiceImpl implements DocClsfService {

	private final DocClsfMapper docClsfMapper;

	private final PrvcFileHldPrstMapper prvcFileHldPrstMapper;

	/* private final DocClsfHistMapper docClsfHistMapper; */

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
		// TODO: 정렬 추가 필요, 대/중/소 그룹.. 등록순
		return docClsfMapper.selectList(searchRequestDto);
	}

	@Override
	public int selectListTotCnt(DocClsfSearchRequestDto searchRequestDto) {
		return docClsfMapper.selectListTotCnt(searchRequestDto);
	}

	@Override
	public int insert(DocClsfInsertRequestDto insertRequestDto) {
		if (isDuplicatedName(insertRequestDto.getDocClsfSeCd(), insertRequestDto.getDocClsfNm())) {
			throw new DuplicateNameException("docClsfNm", "값이 중복입니다.");
		}
		if (!DocClsfSeCd.S.name().equals(insertRequestDto.getDocClsfSeCd())) {
			insertRequestDto.setUseEn("Y");
			insertRequestDto.setPrvcInclYn("N");
		}
		int docClsfInsertRet = docClsfMapper.insert(insertRequestDto);
		if (docClsfInsertRet != 0 && isPrvcIncl(insertRequestDto.getDocClsfSeCd(), insertRequestDto.getPrvcInclYn())) {
			insertRequestDto.getPrvcFileHldPrst().setDocClsfNo(insertRequestDto.getDocClsfNo());
			prvcFileHldPrstMapper.insert(insertRequestDto.getPrvcFileHldPrst());
		}
//		createDocClsfHist(docClsfNo);
		return docClsfInsertRet;
	}

	private boolean isDuplicatedName(String docClsfSeCd, String docClsfNm) {
		return docClsfMapper.countByDocClsfNm(docClsfSeCd, docClsfNm) > 0;
	}

	private boolean isDuplicatedNameExcludingDocClsfNo(String docClsfSeCd, String docClsfNm, String docClsfNo) {
		return docClsfMapper.countByDocClsfNmExcludingDocClsfNo(docClsfSeCd, docClsfNm, docClsfNo) > 0;
	}

	@Override
	public int update(DocClsfUpdateRequestDto updateRequestDto) {
		DocClsfVO old = docClsfMapper.select(updateRequestDto.getDocClsfNo());
		if (isDuplicatedNameExcludingDocClsfNo(old.getDocClsfSeCd(), updateRequestDto.getDocClsfNm(),
				old.getDocClsfNo())) {
			throw new DuplicateNameException("docClsfNm", "값이 중복입니다.");
		}
		int ret = docClsfMapper.update(updateRequestDto);
		if (ret != 0) {
			if (isPrvcIncl(old.getDocClsfSeCd(), updateRequestDto.getPrvcInclYn())) {
				if (old.getPrvcFileHldPrst() != null) {
					updateRequestDto.getPrvcFileHldPrst().setDocClsfNo(updateRequestDto.getDocClsfNo());
					prvcFileHldPrstMapper.update(updateRequestDto.getPrvcFileHldPrst());
				} else {
					prvcFileHldPrstMapper.insert(updateRequestDto.getPrvcFileHldPrst());
				}
			} else {
				prvcFileHldPrstMapper.delete(old.getDocClsfNo());
			}
		}
		return ret;
	}

	@Override
	public void delete(String docClsfNo) {
		DocClsfVO docClsf = docClsfMapper.select(docClsfNo);
		if (DocClsfSeCd.S.name().equals(docClsf.getDocClsfSeCd())) {
			// TODO : 해당 문서분류 사용하는 전자문서 있는지 체크 후 처리 로직 추가 필요
			deleteLeafDocClsf(docClsfNo);
			// TODO : createDocClsfHist
		} else {
			List<DocClsfVO> children = getChildren(docClsfNo);
			if (!children.isEmpty()) {
				for (DocClsfVO child : children) {
					delete(child.getDocClsfNo());
				}
			}
			docClsfMapper.delete(docClsfNo);
			// TODO : createDocClsfHist
		}
	}

	private void deleteLeafDocClsf(String docClsfNo) {
		prvcFileHldPrstMapper.delete(docClsfNo);
		docClsfMapper.delete(docClsfNo);
	}
	/*
	 * private void createDocClsfHist(String docClsfNo) { DocClsfVO docClsf =
	 * docClsfMapper.select(docClsfNo); DocClsfHistVO docClsfHist = new
	 * DocClsfHistVO(); docClsfHist.setDocClsf(docClsf);
	 * docClsfHist.setMdfrDetail("문서분류 수정");
	 * docClsfHist.setMdfrIp("111.111.111.111"); docClsfHist.setMdfrEqmt("PC");
	 * docClsfHistMapper.insert(docClsfHist); }
	 */

	private boolean isPrvcIncl(String docClsfSeCd, String prvcInclYn) {
		return "Y".equals(prvcInclYn) && DocClsfSeCd.S.name().equals(docClsfSeCd);

	}
}

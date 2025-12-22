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
import egovframework.com.edoc.clsf.dto.request.DocClsfUpdateRequestDto;
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
		if (!DocClsfSeCd.S.name().equals(insertRequestDto.getDocClsfSeCd())) {
			insertRequestDto.setUseEn("Y");
			insertRequestDto.setPrvcInclYn("N");
		}
		int docClsfInsertRet = docClsfMapper.insert(insertRequestDto);
		if (docClsfInsertRet != 0 && isPrvcIncl(insertRequestDto.getDocClsfSeCd(), insertRequestDto.getPrvcInclYn())) {
			insertRequestDto.getPrvcFileHldPrst().setDocClsfNo(docClsfNo);
			insertRequestDto.getPrvcFileHldPrst()
					.setPrvcFileHldPrstNo(UUID.randomUUID().toString().substring(0, 20));
			prvcFileHldPrstMapper.insert(insertRequestDto.getPrvcFileHldPrst());
		}
//		createDocClsfHist(docClsfNo);
		return docClsfInsertRet;
	}

	@Override
	public int update(DocClsfUpdateRequestDto updateRequestDto) {
		DocClsfVO old = docClsfMapper.select(updateRequestDto.getDocClsfNo());
		int ret = docClsfMapper.update(updateRequestDto);
		if (ret != 0) {
			if (isPrvcIncl(old.getDocClsfSeCd(), updateRequestDto.getPrvcInclYn())) {
				if (old.getPrvcFileHldPrst() != null) {
					updateRequestDto.getPrvcFileHldPrst().setDocClsfNo(updateRequestDto.getDocClsfNo());
					prvcFileHldPrstMapper.update(updateRequestDto.getPrvcFileHldPrst());
				} else {
					prvcFileHldPrstMapper.insert(updateRequestDto.getPrvcFileHldPrst());
				}
			}
		} else {
			prvcFileHldPrstMapper.delete(old.getDocClsfNo(), old.getPrvcFileHldPrst().getPrvcFileHldPrstNo());
		}
		return ret;
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
		System.out.println(prvcInclYn + "!!!!");
		System.out.println("Y".equals(prvcInclYn) && DocClsfSeCd.S.name().equals(docClsfSeCd));
		return "Y".equals(prvcInclYn) && DocClsfSeCd.S.name().equals(docClsfSeCd);

	}
}

package egovframework.com.edoc.clsf.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import egovframework.com.edoc.clsf.domain.model.DocClsfVO;
import egovframework.com.edoc.clsf.dto.request.DocClsfInsertRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfSearchRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfUpdateRequestDto;

@Mapper
public interface DocClsfMapper {
	
	DocClsfVO select(String docClsfNo);
	
	List<DocClsfVO> selectListByDocClsfSeCd(String docClsfSeCd);
	
	List<DocClsfVO> selectListByUpDocClsfNo(String docClsfNo);

	List<DocClsfVO> selectList(DocClsfSearchRequestDto searchRequestDto);

	int selectListTotCnt(DocClsfSearchRequestDto searchRequestDto);

	int insert(DocClsfInsertRequestDto insertRequestDto);

	int update(DocClsfUpdateRequestDto updateRequestDto);

	int delete(String docClsfNo);

	int countByDocClsfNm(String docClsfSeCd, String docClsfNm);

	int countByDocClsfNmExcludingDocClsfNo(String docClsfSeCd, String docClsfNm, String docClsfNo);
}

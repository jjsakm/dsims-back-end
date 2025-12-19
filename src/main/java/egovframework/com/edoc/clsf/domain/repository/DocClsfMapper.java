package egovframework.com.edoc.clsf.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import egovframework.com.edoc.clsf.domain.model.DocClsfVO;
import egovframework.com.edoc.clsf.dto.request.DocClsfInsertRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfSearchRequestDto;

@Mapper
public interface DocClsfMapper {
	
	DocClsfVO select(String docClsfNo);
	
	List<DocClsfVO> selectListByDocClsfSeCd(String docClsfSeCd);
	
	List<DocClsfVO> selectListByUpDocClsfNo(String docClsfNo);

	List<DocClsfVO> selectList(DocClsfSearchRequestDto searchRequestDto);

	int selectListTotCnt(DocClsfSearchRequestDto searchRequestDto);

	int insert(DocClsfInsertRequestDto docClsfVO);
}

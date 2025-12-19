package egovframework.com.edoc.clsf.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import egovframework.com.edoc.clsf.domain.model.DocClsfSearchVO;
import egovframework.com.edoc.clsf.domain.model.DocClsfVO;

@Mapper
public interface DocClsfMapper {
	
	DocClsfVO select(String docClsfNo);
	
	List<DocClsfVO> selectListByDocClsfSeCd(String docClsfSeCd);
	
	List<DocClsfVO> selectListByUpDocClsfNo(String docClsfNo);

	List<DocClsfVO> selectList(DocClsfSearchVO searchVO);

	int selectListTotCnt(DocClsfSearchVO searchVO);
}

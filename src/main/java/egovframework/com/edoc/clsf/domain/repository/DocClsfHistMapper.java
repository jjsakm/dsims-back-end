package egovframework.com.edoc.clsf.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import egovframework.com.edoc.clsf.domain.model.DocClsfHistVO;

@Mapper
public interface DocClsfHistMapper {
	
	int insert(DocClsfHistVO docClsfHist);
	
	DocClsfHistVO select(String docClsfHstryNo);
	
	List<DocClsfHistVO> selectListByDocClsfNo(String docClsfNo);

	void deleteByDocClsfNo(String docClsfNo);
}

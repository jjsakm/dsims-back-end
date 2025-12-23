package egovframework.com.edoc.clsf.dto.request;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "문서분류 검색 조건")
@Getter
@Setter
public class DocClsfSearchRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8099190759478885825L;

	@Schema(description = "대분류 번호", example = "")
	private String docLclsfNo;
	
	@Schema(description = "중분류 번호", example = "")
	private String docMclsfNo;
	
	@Schema(description = "소분류 번호", example = "")
	private String docSclsfNo;

	@Schema(description = "문서분류명", example = "")
	private String docClsfNm = "";

	@Schema(description = "개인정보 포함여부(Y:포함, N:미포함)", example = "")
	private String prvcInclYn;

	@Schema(description = "사용유무(Y:사용, N:미사용)", example = "")
	private String useEn;

	@Schema(description = "현재페이지", example = "")
	private int pageIndex = 1;

	@Schema(description = "페이지갯수", example = "")
	private int pageUnit = 10;

	@Schema(description = "페이지사이즈", example = "")
	private int pageSize = 10;

	@Schema(description = "firstIndex", example = "")
	private int firstIndex = 1;

	@Schema(description = "lastIndex", example = "")
	private int lastIndex = 1;

	@Schema(description = "recordCountPerPage", example = "")
	private int recordCountPerPage = 10;

	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
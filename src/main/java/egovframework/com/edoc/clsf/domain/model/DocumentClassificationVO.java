package egovframework.com.edoc.clsf.domain.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "문서분류")
@Getter
@Setter
public class DocumentClassificationVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3067138537477155300L;

	@Schema(description = "문서분류 번호", example="")
	private String docClsfNo;

	@Schema(description = "문서분류 구분코드", example="")
    private String docClsfSeCd;

	@Schema(description = "문서분류명", example="")
    private String docClsfNm = "";

	@Schema(description = "상위문서분류 번호", example="")
	private String upDocClsfNo;
	
	@Schema(description = "대분류 번호", example="")
	private String docLclsfNo;
	
	@Schema(description = "중분류 번호", example="")
	private String docMclsfNo;

	@Schema(description = "소분류 번호", example="")
    private String docSclsfNo;
	
	@Schema(description = "대분류명", example="")
	private String docLclsfNm;
	
	@Schema(description = "중분류명", example="")
	private String docMclsfNm;

	@Schema(description = "소분류명", example="")
    private String docSclsfNm;

	@Schema(description = "개인정보포함여부", example="")
    private String prvcInclYn ;

	@Schema(description = "사용유무", example="")
    private String useEn;

	@Schema(description = "등록일자")
    private Date regYmd;

	@Schema(description = "등록자", example="")
    private String rgtrId;

	@Schema(description = "수정일자")
    private Date mdfcnYmd;

	@Schema(description = "수정자", example="")
    private String mdfrId;
    /**
     * toString 메소드를 대치한다.
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}